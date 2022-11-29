package com.example.randomdoggen.app.database.cacheDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.randomdoggen.app.database.dao.DogsDao
import com.example.randomdoggen.app.database.entity.DogsEntity

@Database(
    entities = [DogsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DogsDatabase : RoomDatabase() {

    abstract fun dogsDao(): DogsDao

    companion object {
        @Volatile
        private var INSTANCE: DogsDatabase? = null

        fun getDatabase(context: Context): DogsDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DogsDatabase::class.java,
                    "dogs_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}