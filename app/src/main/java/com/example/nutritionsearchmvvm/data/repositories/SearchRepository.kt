package com.example.nutritionsearchmvvm.data.repositories

import androidx.lifecycle.LiveData
import com.example.nutritionsearchmvvm.data.entities.Item
import com.example.nutritionsearchmvvm.data.network.MyApi
import com.example.nutritionsearchmvvm.data.network.Responses.SearchResponse
import com.example.nutritionsearchmvvm.data.network.SafeApiRequest

import retrofit2.Response

class SearchRepository(
    private val api: MyApi
) : SafeApiRequest(){

    suspend fun search( query: String) : SearchResponse{

        return apiRequest { api.search(query) }

            }
    }


