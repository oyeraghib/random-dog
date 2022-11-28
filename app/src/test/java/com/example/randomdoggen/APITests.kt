package com.example.randomdoggen

import android.util.Log
import com.example.randomdoggen.api.client.RandomDogClient
import kotlinx.coroutines.runBlocking
import org.junit.Test
import timber.log.Timber

class APITests {

    @Test
    fun `check random dog generation`() {
        runBlocking {
            val response = RandomDogClient.retrofitApi.getRandomDog()
            Log.d("TESTTAG", "$response")
        }
    }
}