package com.vagapov.amir.firstkotlinapp.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit


object ServerGenerator {

    private val BASE_URL: String = "https://api.coinmarketcap.com/v1/"
    private val httpClient : OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()

    private val retrofit : Retrofit = Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    private val serverApi : ServerApi = retrofit.create(ServerApi::class.java)

    fun getApi() :ServerApi = serverApi

}