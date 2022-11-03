package com.example.testandroidsuperhero.data.api

import com.example.testandroidsuperhero.URL_API
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getRetrofit(): Retrofit {

    return Retrofit.Builder()
        .baseUrl(URL_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}