package com.example.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostRecyclerViewAdapter(var postList: List<Post>):RecyclerView.Adapter<postViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.posts_list_item,parent,false)
        return postViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
       var currentPosts=postList[position]
        holder.user.text=currentPosts.userId.toString()
        holder.Id.text=currentPosts.id.toString()
        holder.head.text=currentPosts.title
        holder.human.text=currentPosts.body
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class postViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var user=itemView.findViewById<TextView>(R.id.tvUserId)
    var Id=itemView.findViewById<TextView>(R.id.tvId)
    var head=itemView.findViewById<TextView>(R.id.tvTitle)
    var human=itemView.findViewById<TextView>(R.id.tvBody)
}