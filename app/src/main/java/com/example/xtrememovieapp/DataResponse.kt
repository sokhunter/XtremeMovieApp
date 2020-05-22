package com.example.xtrememovieapp

import com.google.gson.annotations.SerializedName

class DataResponse (
    @SerializedName("page")
    val page: Int?,
    @SerializedName("total_results")
    val total_results: Int?,
    @SerializedName("total_pages")
    val total_pages: Int?,
    @SerializedName("results")
    val results: ArrayList<Movie>
)