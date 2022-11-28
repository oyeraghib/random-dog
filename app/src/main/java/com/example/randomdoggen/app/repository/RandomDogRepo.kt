package com.example.randomdoggen.app.repository

import com.example.randomdoggen.api.client.RandomDogClient
import com.example.randomdoggen.api.models.response.GenerateDogResponse

class RandomDogRepo(private val randomDogClient: RandomDogClient) {

    //Generate random dog
    suspend fun generateRandomDog(): GenerateDogResponse {
        val response = randomDogClient.retrofitApi.getRandomDog()
        return response.body()!!
    }
}