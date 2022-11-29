package com.example.randomdoggen.app.repository

import androidx.lifecycle.LiveData
import com.example.randomdoggen.api.client.RandomDogClient
import com.example.randomdoggen.api.models.response.GenerateDogResponse
import com.example.randomdoggen.app.database.dao.DogsDao
import com.example.randomdoggen.app.database.entity.DogsEntity

class RandomDogRepo(private val randomDogClient: RandomDogClient, private val dogsDao: DogsDao) {

    //Generate random dog
    suspend fun generateRandomDog(): GenerateDogResponse {
        val response = randomDogClient.retrofitApi.getRandomDog()
        return response.body()!!
    }

    //Save dog image
    suspend fun saveDog(image: DogsEntity) = dogsDao.saveDog(image)

    //Read all dogs
    fun readAllDogs(): LiveData<List<String>> = dogsDao.readDogs()

    //Delete all dogs
//    suspend fun deleteDogs() = dogsDao.deleteAllDogs()
}