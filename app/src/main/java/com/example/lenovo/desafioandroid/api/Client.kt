package com.example.lenovo.desafioandroid.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object  Client {

    private const val API_URL = "https://api.github.com"


    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        //retrofit.create(Capa::class.java)
        retrofit.create(ApiService::class.java)
    }
}