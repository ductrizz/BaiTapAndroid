package com.trild.githubfind.Model

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trild.githubfind.databinding.UserItemBinding


class AdapterFollowing (private val context: Context, private val clickItem: (String?)->Unit): RecyclerView.Adapter<AdapterFollowing.ViewHolder>() {
    private var list: MutableList<FollowingModel> = mutableListOf()

    class ViewHolder(private val itemRowBiding: UserItemBinding) : RecyclerView.ViewHolder(itemRowBiding.root) {

        fun bindData(context: Context, clickItem: (String?) -> Unit, userFollower: FollowingModel){
            Glide.with(context).load(userFollower.avatar_url).into(itemRowBiding.imgUsersAvata)
            itemRowBiding.txtUserFollow.text = userFollower.login
            itemRowBiding.txtIDFollow.text = userFollower.id.toString()
            itemRowBiding.itemUser.setOnClickListener {
                clickItem(userFollower.login)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list.get(position)
        holder.bindData(context,clickItem, item)
    }

    override fun getItemCount(): Int = list.size

    fun addAll(newList: List<FollowingModel>){
        list.addAll(newList)
        notifyDataSetChanged()
    }
}