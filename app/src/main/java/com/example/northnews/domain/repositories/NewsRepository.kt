package com.example.northnews.domain.repositories

import com.example.northnews.data.api.RetrofitInstance
import com.example.northnews.data.db.ArticleDatabase

class NewsRepository(
    val database: ArticleDatabase
) {
    suspend fun getNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getNews(countryCode, pageNumber)
}