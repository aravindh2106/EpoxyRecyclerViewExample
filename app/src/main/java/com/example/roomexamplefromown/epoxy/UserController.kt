package com.example.roomexamplefromown.epoxy


import com.airbnb.epoxy.Typed2EpoxyController
import com.example.roomexamplefromown.header
import com.example.roomexamplefromown.model.User
import com.example.roomexamplefromown.rowItems

class UserController() : Typed2EpoxyController<List<User>, (User) -> Unit>() {

    override fun buildModels(data: List<User>, itemClick: (User) -> Unit) {
        header {
            id("list_items")
            header("LIST OF ITEMS WITH PRICE")
        }
        data.forEachIndexed { index, s ->
            rowItems {
                id("$index")
                name(s.name)
                bio(s.bio)
                onClick { _ ->
                    itemClick(s)
                }
            }
        }
    }
}