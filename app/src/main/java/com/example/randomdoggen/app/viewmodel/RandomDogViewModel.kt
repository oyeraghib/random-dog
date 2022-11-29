package com.example.randomdoggen.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomdoggen.api.models.response.GenerateDogResponse
import com.example.randomdoggen.app.database.entity.DogsEntity
import com.example.randomdoggen.app.repository.RandomDogRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RandomDogViewModel(private val repository: RandomDogRepo) : ViewModel() {

    //Get random dog
    private val _randomDog: MutableLiveData<GenerateDogResponse> = MutableLiveData()
    val randomDog: LiveData<GenerateDogResponse> = _randomDog

    fun generateRandomDog() = viewModelScope.launch(Dispatchers.IO) {
        repository.generateRandomDog().let {
            saveDog(DogsEntity(imageUrl = "${it.message}"))
            _randomDog.postValue(it)
        }
    }

    //Save dog image
    private fun saveDog(image: DogsEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveDog(image)
    }

    //Read all dogs
    val readAllDogs: LiveData<List<String>> = repository.readAllDogs()

  /*  //Delete all dogs
    val deleteAllDogs = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteDogs()
    }*/
}