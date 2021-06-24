package com.trild.baitapapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter (private val context: Context, private val list: FollowingModel) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.test_follower, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textUserFollower = view.findViewById<TextView>(R.id.txtUserFollowertest)
        val textIDFollower = view.findViewById<TextView>(R.id.txtIDFollowertest)
        val imageFollower = view.findViewById<ImageView>(R.id.imgFollowertest)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userFollower = list.get(position)
        holder.textUserFollower.text = userFollower.login
        holder.textIDFollower.text = userFollower.id.toString()
        Glide.with(context).load(userFollower.avatar_url).into(holder.imageFollower)

    }

}