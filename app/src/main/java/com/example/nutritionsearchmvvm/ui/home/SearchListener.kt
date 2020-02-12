package com.example.nutritionsearchmvvm.ui.home

import com.example.nutritionsearchmvvm.data.entities.List

interface SearchListener {
    fun onStarted()
    fun onSuccess(list: List)
    fun onFailure(message:String)
}