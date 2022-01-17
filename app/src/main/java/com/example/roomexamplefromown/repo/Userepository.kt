package com.example.roomexamplefromown.repo

import com.example.roomexamplefromown.db.UserDao
import com.example.roomexamplefromown.model.User

class Userepository(private val dao: UserDao) {
    val allData = dao.readAllData()

    suspend fun addUser(user: User) {
        dao.addUser(user)
    }

    suspend fun updateUser(user: User) {
        dao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        dao.deleteUser(user)
    }

    suspend fun allDelete() {
        dao.deleteAllUser()
    }
    suspend fun perticularName(){

    }
    suspend fun getPerticularNumber(){

    }
    suspend fun getNameByID(){

    }
    suspend fun getNumberByID(){

    }

}