package com.example.northnews.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.northnews.data.api.response.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateInsert(article: Article): Long

    @Delete
    suspend fun deleteArticle(article: Article)
}