package com.trild.githubfind.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.trild.githubfind.Model.AdapterFollower
import com.trild.githubfind.Model.AdapterFollowing
import com.trild.githubfind.databinding.GithubContentBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GithubFragment : Fragment() {
    private lateinit var viewModel : ViewModel
    private var _binding: GithubContentBinding? = null
    private val binding get() = _binding!!
    private var userName = "ToanMobile"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GithubContentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.initDatabase(requireContext())
        getData()
        binding.btnSearch.setOnClickListener {
            if (binding.etxtSearch.text?.length?:0 > 0){
                userName = binding.etxtSearch.text.toString()
                getData()
            }
        }
    }

    fun getData(){
        viewModel.getModelDetailAPI(userName){UserDetail ->
            UserDetail?.apply {
                Log.e("UserModelFragment:==",""+UserDetail.toString())
                Glide.with(this@GithubFragment).load(UserDetail.avatar_url).into(binding.imgAvata)
                binding.txtUserName.text = name
                binding.txtLogin.text = "( "+login+" )"
                binding.txtBIO.text = "BIO: " + bio
                binding.txtCountFollower.text = "$followers Followers"
                binding.txtCountFollowing.text = "$following Following"
                binding.txtCountRepos.text = "$public_repos Repos"
            }
        }


        viewModel.getFollowerDetailAPI(userName){listFollower ->
            listFollower?.apply{
                Log.e("ListFollowerFragment:", listFollower.toString())
                val adapterFollower = AdapterFollower(requireContext()){newName ->
                    userName = newName ?: ""
                    getData()
                }
                adapterFollower.addAll(this)
                binding.recycleFollower.adapter = adapterFollower
            }

        }

        viewModel.getFollowingDetailAPI(userName){listFollowing ->
            listFollowing?.apply {
                Log.e("ListFollowingFragment:", listFollowing.toString())
                val adapterFollowing = AdapterFollowing(requireContext()){newName ->
                    userName = newName ?: ""
                    getData()
                }
                adapterFollowing.addAll(this)
                binding.recycleFollowing.adapter = adapterFollowing
            }

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}