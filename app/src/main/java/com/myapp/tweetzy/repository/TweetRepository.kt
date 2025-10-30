package com.myapp.tweetzy.repository

import android.util.Log
import com.myapp.tweetzy.api.TweetzyAPI
import com.myapp.tweetzy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

private const val TAG = "TweetRepository"

class TweetRepository @Inject constructor(private val tweetzyAPI: TweetzyAPI){

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets


    suspend fun getCategories() {
        try {
            val response: Response<List<String>> = tweetzyAPI.getCategories()
            if (response.isSuccessful && response.body() != null) {
                _categories.value = response.body()!!
                Log.d(TAG, "Categories fetched successfully. Count: ${_categories.value.size}")
            } else {
                Log.e(TAG, "Categories fetch failed. Code: ${response.code()}")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Exception fetching categories: ${e.message}", e)
        }
    }

    suspend fun getTweets(category: String) {
        // FIX: Use '$.tweets[?(@.category=='$category')]'
        // This is the most likely correct path if the JSON is wrapped in a "tweets" key.
        val jsonPathFilter = "$.tweets[?(@.category=='$category')]"

        try {
            val response: Response<List<TweetListItem>> = tweetzyAPI.getTweets(jsonPathFilter)

            if (response.isSuccessful && response.body() != null) {
                // Critical Fix: Use .value to update the StateFlow
                val tweetsResult = response.body()!!
                _tweets.value = tweetsResult
                Log.d(TAG, "Tweets fetched for '$category'. Count: ${tweetsResult.size}. Filter: $jsonPathFilter")
            } else {
                Log.e(TAG, "Tweets fetch failed. Code: ${response.code()}. Message: ${response.message()}")
            }
        } catch (e: Exception) {
            // This happens if the network is down or the JSON body cannot be parsed
            Log.e(TAG, "Exception fetching tweets for '$category': ${e.message}", e)
        }
    }

}