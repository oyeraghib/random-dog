package com.example.randomdoggen.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomdoggen.api.models.response.GenerateDogResponse
import com.example.randomdoggen.app.repository.RandomDogRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RandomDogViewModel(private val repository: RandomDogRepo) : ViewModel() {

    //Get random dog
    private val _randomDog: MutableLiveData<GenerateDogResponse> = MutableLiveData()
    val randomDog: LiveData<GenerateDogResponse> = _randomDog

    fun generateRandomDog() = viewModelScope.launch(Dispatchers.IO) {
        repository.generateRandomDog().let {
            _randomDog.postValue(it)
        }
    }
}