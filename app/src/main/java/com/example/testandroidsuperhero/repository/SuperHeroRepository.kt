package com.example.testandroidsuperhero.repository

import com.example.testandroidsuperhero.HASH_KEY
import com.example.testandroidsuperhero.PUBLIC_KEY
import com.example.testandroidsuperhero.data.api.APIService
import com.example.testandroidsuperhero.data.api.getRetrofit
import com.example.testandroidsuperhero.data.model.ResponseApi
import javax.inject.Inject

class SuperHeroRepository @Inject constructor() {

    suspend fun fetchSuperHeroData(): ResponseApi? {
        val call = getRetrofit().create(APIService::class.java)
            .fetchSuperHeroData("characters?ts=1&apikey=$PUBLIC_KEY&hash=$HASH_KEY")
        return call.body()
    }
}