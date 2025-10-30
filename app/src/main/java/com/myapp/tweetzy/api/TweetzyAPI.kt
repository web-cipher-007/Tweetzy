package com.myapp.tweetzy.api

import com.myapp.tweetzy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


interface TweetzyAPI {
    @GET("/v3/b/68ee3596ae596e708f1304ec?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>

    @GET("/v3/b/68ee3596ae596e708f1304ec?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>
}
