package com.example.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var postView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postView=findViewById(R.id.rvPosts)
        getPost()
    }
    fun getPost(){
        val retrofit=Apiclient.buildApiClient(ApiInterface::class.java)
        val request=retrofit.getPosts()
        request.enqueue(object :Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
              if(response.isSuccessful){
                  var posts=response.body()!!
                  var postAdapter=PostRecyclerViewAdapter(posts)
                   postView.adapter=postAdapter
                  postView.layoutManager=LinearLayoutManager(baseContext)
              }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext, "Request failed", Toast.LENGTH_LONG).show()
            }

        })
    }
}