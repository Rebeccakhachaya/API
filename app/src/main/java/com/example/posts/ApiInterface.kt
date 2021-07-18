package com.example.posts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getPost():Call<List<Post>>

    @GET("posts/{post_id}")
    fun getPost(@Path("post_id")post_id:Int):Call<Post>
   @GET("post/{post_id}/comments")
   fun getComments(@Path("post_id")id:Int):Call<List<Comments>>



}