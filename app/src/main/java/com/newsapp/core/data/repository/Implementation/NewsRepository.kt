package com.newsapp.core.data.repository.Implementation

import com.newsapp.core.data.remote.services.NewsService
import com.newsapp.core.data.repository.Interface.INewsRepository

class NewsRepository (private val api: NewsService) : INewsRepository {
    override fun getAll() {

        TODO("Not yet implemented")
    }
}