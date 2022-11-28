package com.example.randomdoggen.api.service

import com.example.randomdoggen.api.models.response.GenerateDogResponse
import retrofit2.Response
import retrofit2.http.GET

interface RandomDogAPI {

    //Get Random Dog
    @GET("random")
    suspend fun getRandomDog(): Response<GenerateDogResponse>
}