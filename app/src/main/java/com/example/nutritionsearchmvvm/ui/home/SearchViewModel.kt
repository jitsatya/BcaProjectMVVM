package com.example.nutritionsearchmvvm.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.nutritionsearchmvvm.data.repositories.SearchRepository
import com.example.nutritionsearchmvvm.util.ApiException
import com.example.nutritionsearchmvvm.util.Coroutines
import com.example.nutritionsearchmvvm.util.NoInternetException

class SearchViewModel(
    private val repository: SearchRepository
) : ViewModel(){

    //val key :String = "CNnMlek3Wy8jYTBGSnp4OxXDb6xQJGbqShmbQ5W1"

    var query: String? = null

    var searchListener: SearchListener? = null

    fun onSearchButtonClicked(view: View){
        searchListener?.onStarted()
        if (query.isNullOrEmpty()){
            searchListener?.onFailure("Please enter a search Text")
            return
        }
        Coroutines.main {
            try {

                val searchResponse = repository.search(query!!)

                searchResponse.list?.let {
                    searchListener?.onSuccess(it)
                    return@main
                }
                searchListener?.onFailure(searchResponse.list.toString()!!)
            }catch (e: ApiException){
                searchListener?.onFailure(e.message!!)
            }catch (e: NoInternetException){
                searchListener?.onFailure(e.message!!)
            }

        }


    }
}