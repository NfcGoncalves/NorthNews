package com.example.northnews.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.northnews.R
import com.example.northnews.presentation.NewsActivity
import com.example.northnews.presentation.viewmodels.NewsViewModel

class NewsFragment: Fragment(R.layout.fragment_news_list) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}