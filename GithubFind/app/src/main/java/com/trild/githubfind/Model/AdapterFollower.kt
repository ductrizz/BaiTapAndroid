package com.trild.githubfind.Model

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trild.githubfind.databinding.UserItemBinding


class AdapterFollower (private val context: Context): RecyclerView.Adapter<AdapterFollower.UserViewHolder>() {
    private var list: MutableList<FollowerModel> = mutableListOf()

    class UserViewHolder(private val itemRowBiding: UserItemBinding) : RecyclerView.ViewHolder(itemRowBiding.root) {

        fun bindData(context: Context, userFollower: FollowerModel){
            Glide.with(context).load(userFollower.avatar_url).into(itemRowBiding.imgUsersAvata)
            itemRowBiding.txtUserFollow.text = userFollower.login
            itemRowBiding.txtIDFollow.text = userFollower.id.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = list.get(position)
        holder.bindData(context, item)
    }

    override fun getItemCount(): Int = list.size

    fun addAll(newList: List<FollowerModel>){
        list.addAll(newList)
        notifyDataSetChanged()
    }
}