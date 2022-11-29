package com.example.randomdoggen.app.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.randomdoggen.app.database.entity.DogsEntity

@Dao
interface DogsDao {

    //Cache dog
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDog(url: DogsEntity)

    //Read list of dogs
    @Query("select image_url from dogs_entity ORDER BY id desc")
    fun readDogs(): LiveData<List<String>>

    //Delete all dogs
    @Query("delete from dogs_entity")
    suspend fun deleteAllDogs()
}