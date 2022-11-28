package com.example.randomdoggen.api.client

import com.example.randomdoggen.api.service.RandomDogAPI
import com.example.randomdoggen.api.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RandomDogClient {

    private val okHttpBuilder = OkHttpClient.Builder()
        .readTimeout(2, TimeUnit.MINUTES)
        .writeTimeout(2, TimeUnit.MINUTES)

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpBuilder.build())
        .addConverterFactory(MoshiConverterFactory.create())

    val retrofitApi = retrofitBuilder.build()
        .create(RandomDogAPI::class.java)
}