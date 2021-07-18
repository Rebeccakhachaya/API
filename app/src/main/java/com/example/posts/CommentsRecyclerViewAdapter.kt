package com.example.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentsRecyclerViewAdapter(var comments: List<Comments>):RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.comments_list_item,parent,false)
        return CommentsViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComments=comments.get(position)
        holder.tvName.text=currentComments.name
        holder.tvEMAIL.text=currentComments.email
        holder.tvcombody.text=currentComments.bodies



    }

    override fun getItemCount(): Int {
        return comments.size
    }
}
class CommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvEMAIL=itemView.findViewById<TextView>(R.id.tvEMAIL)
    var tvcombody=itemView.findViewById<TextView>(R.id.tvcombody)
}
