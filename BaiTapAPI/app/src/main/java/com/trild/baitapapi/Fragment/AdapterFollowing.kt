package com.trild.baitapapi.Fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trild.baitapapi.API.UserFollowing
import com.trild.baitapapi.R

class AdapterFollowing(private val context: Context, private val list: List<UserFollowing>) : RecyclerView.Adapter<AdapterFollowing.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_following, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userFollowing = list.get(position)
        holder.textUserFollowing.text = userFollowing.login
        holder.textIDFollowing.text = userFollowing.id.toString()
        Glide.with(context).load(userFollowing.avatar_url).into(holder.imageFollowing)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textUserFollowing = view.findViewById<TextView>(R.id.txtUserFollowing)
        val textIDFollowing = view.findViewById<TextView>(R.id.txtIDFollowing)
        val imageFollowing = view.findViewById<ImageView>(R.id.imgFollowing)
    }
}
