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

class FragmentFollowing : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_following,container,false)

        val githubDataRepository = GithubDataRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val listUserFollowing = githubDataRepository.getListFollowingfroAPI("ToanMobile") ?: emptyList()
            withContext(Dispatchers.Main) {
                view.findViewById<RecyclerView>(R.id.recycleFollowing).adapter =
                    AdapterFollowing(view.context,listUserFollowing)
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnBackUserflowing).setOnClickListener {
            findNavController().navigate(R.id.action_FragmentFollowing_to_FragmentUser)
        }
    }

}