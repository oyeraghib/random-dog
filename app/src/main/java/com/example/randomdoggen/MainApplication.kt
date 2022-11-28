package com.example.randomdoggen

import android.app.Application
import com.example.randomdoggen.api.client.RandomDogClient
import com.example.randomdoggen.app.repository.RandomDogRepo
import timber.log.Timber

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
    //Single Repo Instance
    /**
     *This makes sure that there is single instance of repository throughout the whole application.
     */
    val randomDogRepo by lazy { RandomDogRepo(RandomDogClient) }
}