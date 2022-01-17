package com.example.roomexamplefromown.ui.enterdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomexamplefromown.model.User
import com.example.roomexamplefromown.repo.Userepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EnterDetailViewModel(private val repository: Userepository) : ViewModel() {

    var readAllData = repository.allData
    private var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete: User

    val inputName = MutableLiveData<String?>()

    val inputBio = MutableLiveData<String?>()

    val saveOrUpdateButtonText = MutableLiveData<String>()
    val deleteOrAllDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "save"
        deleteOrAllDeleteButtonText.value = "delete all"
    }




    fun addUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.addUser(user)
        //  statusMessage.value = Event("successfully added")
    }

    fun updateData(user: User) = viewModelScope.launch(Dispatchers.Main) {
        repository.updateUser(user)
        inputName.value = null
        inputBio.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "save"
        deleteOrAllDeleteButtonText.value = "clear all"
    }

    fun deleteData(user: User) = viewModelScope.launch(Dispatchers.Main) {
        repository.deleteUser(user)
        inputName.value = null
        inputBio.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "save"
        deleteOrAllDeleteButtonText.value = "clear all"
    }

    fun clearAllData() = viewModelScope.launch(Dispatchers.IO) {
        repository.allDelete()
    }


    fun save() {
        if (isUpdateOrDelete){
            userToUpdateOrDelete.name = inputName.value!!
            userToUpdateOrDelete.bio = inputBio.value!!
            updateData(userToUpdateOrDelete)
        }else{
            val name = inputName.value!!
            val bio = inputBio.value!!
            addUser(User(0, name, bio))
            inputName.value = null
            inputBio.value = null
        }

    }

    fun initUpdateAndDelete(user: User) {
        inputName.value = user.name
        inputBio.value = user.bio
        isUpdateOrDelete = true
        userToUpdateOrDelete = user
        saveOrUpdateButtonText.value = "update"
        deleteOrAllDeleteButtonText.value = "delete"
    }

    fun allDelete() {
        if (isUpdateOrDelete){
            deleteData(userToUpdateOrDelete)
        }else{
            clearAllData()
        }

    }
}