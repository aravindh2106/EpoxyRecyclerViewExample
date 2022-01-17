package com.example.roomexamplefromown.event

import androidx.lifecycle.Observer

open class Event<out T>(private val content: T) {
    var hasBeenHandled = false
    fun contentIfNotHandled():T?{
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content

        }
    }

}