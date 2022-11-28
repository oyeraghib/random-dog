package com.example.randomdoggen.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.randomdoggen.app.repository.RandomDogRepo

class ViewModelFactory(private val repo: RandomDogRepo) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(RandomDogViewModel::class.java)) {
            return RandomDogViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}