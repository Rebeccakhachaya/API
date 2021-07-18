package com.example.posts

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class commentsActivity : AppCompatActivity() {
    var post_id = 0
    lateinit var tvposttitle: TextView
    lateinit var tvpostbody: TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)
        setContentView(R.layout.activity_comments)
        post_id = intent.getIntExtra("post_id", 0)
        castViews()
        getPost()
        getComments()
    }


    fun castViews() {
        tvposttitle=findViewById(R.id.tvposttitle)
        tvpostbody=findViewById(R.id.tvpostbody)
    }

    fun getPost() {
        if (post_id == 0) {
            Toast.makeText(baseContext, "not found", Toast.LENGTH_LONG).show()
            finish()
        }

        var Apiclient = Apiclient.buildApiClient(ApiInterface::class.java)
        var request = Apiclient.getPost(post_id)
        request.enqueue(object : Callback<Post?> {
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    tvposttitle.text = post?.title
                    tvpostbody.text = post?.body
                }
            }

            override fun onFailure(call: Call<Post?>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }




   fun getComments(){
       var rvComments = findViewById<RecyclerView>(R.id.rvcomments)
       var apiclient =Apiclient.buildApiClient(ApiInterface::class.java)
       var request=apiclient.getComments(post_id)
       request.enqueue(object:Callback<List<Comments>> {
         override fun onResponse(call: Call<List<Comments>>, response: Response<List<Comments>>
          ) {
               var comment = response.body()!!
                var commentsadapter = CommentsRecyclerViewAdapter(comment)
                rvComments.adapter = commentsadapter
               rvComments.layoutManager = LinearLayoutManager(baseContext)
           }
          override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
               Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
           }
        })
////getPost()
    }





}

private fun <T> Call<T>.enqueue(callback: Callback<List<Comment>>) {

}














