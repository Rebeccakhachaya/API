package com.example.posts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PostRecyclerViewAdapter(var postList: List<Post>,var context: Context):RecyclerView.Adapter<postViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.posts_list_item,parent,false)
        return postViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
       var currentPosts=postList[position]

        holder.head.text=currentPosts.title
        holder.human.text=currentPosts.body
        holder.cvpost.setOnClickListener{
            var intent=Intent(context, commentsActivity::class.java)
            intent.putExtra("post_id",currentPosts.id)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class postViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    var head=itemView.findViewById<TextView>(R.id.tvTitle)
    var human=itemView.findViewById<TextView>(R.id.tvBody)
    var cvpost=itemView.findViewById<CardView>(R.id.cvpost)
}