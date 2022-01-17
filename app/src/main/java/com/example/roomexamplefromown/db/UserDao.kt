package com.example.roomexamplefromown.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomexamplefromown.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_detail")
    suspend fun deleteAllUser()

    @Query("SELECT * FROM user_detail ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>
}