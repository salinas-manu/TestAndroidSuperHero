package com.example.testandroidsuperhero.data.api

import com.example.testandroidsuperhero.data.model.ResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun fetchSuperHeroData(@Url url:String):Response<ResponseApi>

    @GET
    suspend fun getSuperHeroById(@Url url:String):Response<ResponseApi>
}