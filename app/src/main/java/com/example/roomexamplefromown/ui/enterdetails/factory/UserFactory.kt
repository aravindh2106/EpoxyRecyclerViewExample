package com.example.roomexamplefromown.ui.enterdetails.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomexamplefromown.repo.Userepository
import com.example.roomexamplefromown.ui.enterdetails.EnterDetailViewModel

class UserFactory(private val repository:Userepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EnterDetailViewModel::class.java)) {
            return EnterDetailViewModel(repository,) as T
        }
        return throw IllegalArgumentException("unknown viewmodel")
    }
}
