package com.example.roomexamplefromown.epoxy

import com.airbnb.epoxy.EpoxyController
import com.example.roomexamplefromown.model.User
import com.example.roomexamplefromown.rowItems

class UserController(
    private val dataList: List<User>,
    private val onClick: (User) -> Unit,
) : EpoxyController() {

    override fun buildModels() {
        dataList.forEachIndexed { index, data ->
            rowItems {
                id("$index")
                name(data.name)
                bio(data.bio)
                onClick { _ ->
                    onClick(data)
                }
            }
        }
    }
}