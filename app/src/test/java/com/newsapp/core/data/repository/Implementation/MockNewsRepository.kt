package com.newsapp.core.data.repository.Implementation

import com.newsapp.core.data.repository.Interface.INewsRepository
import com.newsapp.core.domain.model.Article
import com.newsapp.core.domain.model.News
import com.newsapp.core.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockNewsRepository : INewsRepository{
    private val news = News(
        mutableListOf<Article>(),
        "ok",
        0
    )
    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkEroor (value:Boolean){
        shouldReturnNetworkError = value
    }

    override fun getAll(): Flow<Resource<News>> {

        return flow {
            if(!shouldReturnNetworkError){
                emit(Resource.Success(news))
            }else{
                emit(Resource.Error<News>(message = "Couldn't reach server, check Your internet connection",data = null))
            }
        }
    }

}