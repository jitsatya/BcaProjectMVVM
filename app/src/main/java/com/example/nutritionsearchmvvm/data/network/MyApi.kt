package com.example.nutritionsearchmvvm.data.network

import com.example.nutritionsearchmvvm.data.network.Responses.SearchResponse
import io.grpc.okhttp.OkHttpChannelBuilder
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {


    @GET("search/?ds=Standard%20Reference&max=50&api_key=CNnMlek3Wy8jYTBGSnp4OxXDb6xQJGbqShmbQ5W1")

    suspend fun search(

        @Query("q") query: String
    ) : retrofit2.Response <SearchResponse>

    companion object{
        operator  fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : MyApi{

            val okhttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okhttpclient)
                .baseUrl("https://api.nal.usda.gov/ndb/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}