package com.example.northnews.data.api

import com.example.northnews.data.NewsResponse
import com.example.northnews.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country")
        countryCode: String = "pt",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("everything")
    suspend fun searchNews(
        @Query("")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}