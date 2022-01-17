package com.example.roomexamplefromown.model

import androidx.room.*


@Entity(tableName = "user_detail")
class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "username")
    var name: String,
    @ColumnInfo(name = "bio")
    var bio: String
)