package com.example.lenovo.desafioandroid.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.lenovo.desafioandroid.R
import com.example.lenovo.desafioandroid.api.Client
import com.example.lenovo.desafioandroid.model.ItemResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.smoothScrollToPosition(0)
        loadJson()


    }

    private fun loadJson() {

        Client.instance.getcapa()
                .enqueue(object : Callback<ItemResponse>{

                    override fun onFailure(call: Call<ItemResponse>?, t: Throwable?) {
                        Toast.makeText(applicationContext, t?.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<ItemResponse>?, response: Response<ItemResponse>?) {
                        val json = response?.body()
                        val gson = Gson().toJson(json)
                        val gsonBuilder = GsonBuilder().create()
                        val homeFeed = gsonBuilder.fromJson(gson, ItemResponse::class.java)
                        runOnUiThread{
                            recyclerview.adapter = ItemAdapter(homeFeed)
                        }
                    }
                })
    }

}
