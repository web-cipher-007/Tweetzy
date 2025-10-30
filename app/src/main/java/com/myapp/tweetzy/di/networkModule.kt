package com.myapp.tweetzy.di

import com.myapp.tweetzy.api.TweetzyAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class networkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideTweetsyAPI(retrofit: Retrofit): TweetzyAPI{
        return retrofit.create(TweetzyAPI::class.java)
    }
}