package com.trild.baitapapi.Fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trild.baitapapi.API.UserFollower
import com.trild.baitapapi.R

class AdapterFollower(private val context: Context, private val list: List<UserFollower>) : RecyclerView.Adapter<AdapterFollower.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_follower, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userFollower = list.get(position)
        holder.textUserFollower.text = userFollower.login
        holder.textIDFollower.text = userFollower.id.toString()
        Glide.with(context).load(userFollower.avatar_url).into(holder.imageFollower)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textUserFollower = view.findViewById<TextView>(R.id.txtUserFollower)
        val textIDFollower = view.findViewById<TextView>(R.id.txtIDFollower)
        val imageFollower = view.findViewById<ImageView>(R.id.imgFollower)
    }
}
