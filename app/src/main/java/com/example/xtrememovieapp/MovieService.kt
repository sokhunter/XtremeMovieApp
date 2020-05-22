package com.example.xtrememovieapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("3/search/movie")
    fun searchMovie(@Query("api_key") api_key: String, @Query("query") query: String) : Call<DataResponse>
}