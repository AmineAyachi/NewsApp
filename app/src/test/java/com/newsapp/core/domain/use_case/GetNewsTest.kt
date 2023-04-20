package com.newsapp.core.domain.use_case

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.newsapp.core.data.repository.Implementation.MockNewsRepository
import com.newsapp.core.util.Resource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetNewsTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var getNews: GetNews
    val mockRepository = MockNewsRepository()

    @Before
    fun setup(){
        getNews = GetNews(mockRepository)
    }

    @Test
    fun `getNews should return, returns success`()  = runBlocking {
        val result  = getNews.invoke().first()
        assertTrue(result is Resource.Success)
        val news = (result as Resource.Success).data
        if (news != null) {
            assertEquals(news.status, "ok")
        }
        if (news != null) {
            assertEquals(news.totalResults, 0)
        }
        if (news != null) {
            assertEquals(news.articles.size, 0)
        }
        mockRepository.setShouldReturnNetworkEroor(true)
        val errorResult = getNews.invoke().first()

        // Verify that the result is an error
        assertTrue(errorResult is Resource.Error)
        assertEquals((errorResult as Resource.Error).message, "Couldn't reach server, check Your internet connection")
    }
}