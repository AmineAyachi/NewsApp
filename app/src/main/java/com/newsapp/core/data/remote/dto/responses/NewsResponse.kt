package com.newsapp.core.data.remote.dto.responses

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)
