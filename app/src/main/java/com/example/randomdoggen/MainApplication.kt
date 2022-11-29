package com.example.randomdoggen

import android.app.Application
import com.example.randomdoggen.api.client.RandomDogClient
import com.example.randomdoggen.app.database.cacheDatabase.DogsDatabase
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
    //Single global database instance
    /**
     * This helps to have single instance of database throughout the whole app lifecycle
     */
    private val database by lazy { DogsDatabase.getDatabase(this) }

    //Single Repo Instance
    /**
     *This makes sure that there is single instance of repository throughout the whole application.
     */
    val randomDogRepo by lazy { RandomDogRepo(RandomDogClient, database.dogsDao()) }
}