package com.example.lenovo.desafioandroid.api

import com.example.lenovo.desafioandroid.model.ItemResponse
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getcapa(
    ): Call<ItemResponse>
}
