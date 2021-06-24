package com.trild.baitapapi.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.trild.baitapapi.R
import com.trild.baitapapi.SetData.GithubDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FragmentFollower : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_follower,container,false)

        val githubDataRepository = GithubDataRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val listUserFollower = githubDataRepository.getListFollowerfroAPI("ToanMobile")?.reversed() ?: emptyList()
            withContext(Dispatchers.Main) {
                view.findViewById<RecyclerView>(R.id.recycleFollower).adapter =
                    AdapterFollower(view.context, listUserFollower)
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnBackUser).setOnClickListener {
            findNavController().navigate(R.id.action_FragmentFollower_to_FragmentUser)

        }
    }


}