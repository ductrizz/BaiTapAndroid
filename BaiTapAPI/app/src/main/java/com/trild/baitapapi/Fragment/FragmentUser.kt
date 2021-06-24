package com.trild.baitapapi.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.orhanobut.logger.Logger
import com.trild.baitapapi.R
import com.trild.baitapapi.SetData.GithubDataRepository
import kotlinx.coroutines.*



class FragmentUser : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnFollower).setOnClickListener {
            findNavController().navigate(R.id.action_FragmentUser_to_FragmentFollower)
        }
        view.findViewById<Button>(R.id.btnFollowing).setOnClickListener {
            findNavController().navigate(R.id.action_FragmentUser_to_FragmentFollowing)
        }

        val githubDataRepository = GithubDataRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val userModel = GithubDataRepository().getUserDetailfroAPI("ToanMobile")
            Logger.e("userModel==:", userModel.toString())
            withContext(Dispatchers.Main) {
                view.findViewById<TextView>(R.id.txtUserName)?.text = userModel?.name ?: ""
                Glide.with(this@FragmentUser).load(userModel?.avatar_url).into(
                    view.findViewById(R.id.imgUser)
                )
            }
        }
    }
}