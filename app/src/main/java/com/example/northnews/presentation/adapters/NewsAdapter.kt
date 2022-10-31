package com.example.northnews.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.northnews.data.api.response.Article
import com.example.northnews.databinding.ItemArticleBinding

class NewsAdapter(
    private val articleList: List<Article>
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root){
        var itemArticleImage: ImageView = binding.itemArticleImage
        var itemArticleTitle: TextView = binding.itemArticleTitle
        var itemArticleSource: TextView = binding.itemArticleSource
        var itemArticleDate: TextView = binding.itemArticleSource

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        val article = articleList[position]
        holder.itemArticleTitle.text = article.title
        holder.itemArticleSource.text = article.publishedAt
        holder.itemArticleDate.text = article.source.name
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(holder.itemArticleImage)
            setOnClickListener {
                onItemClickListener?.let { it(article) }
            }
        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}
