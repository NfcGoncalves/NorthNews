package com.example.northnews.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.northnews.R
import com.example.northnews.data.db.ArticleDatabase
import com.example.northnews.databinding.ActivityNewsBinding
import com.example.northnews.domain.factories.NewsViewModelProviderFactory
import com.example.northnews.domain.repositories.NewsRepository
import com.example.northnews.presentation.viewmodels.NewsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    private lateinit var bottomNavView: BottomNavigationView
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        setupNavController()
    }

    private fun setupNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.activityNewsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavView = findViewById(R.id.activityNewsBottomNavigation)
        NavigationUI.setupWithNavController(bottomNavView, navController)
    }
}