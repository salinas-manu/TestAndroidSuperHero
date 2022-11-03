package com.example.testandroidsuperhero.repository

import com.example.testandroidsuperhero.HASH_KEY
import com.example.testandroidsuperhero.PUBLIC_KEY
import com.example.testandroidsuperhero.data.api.APIService
import com.example.testandroidsuperhero.data.api.getRetrofit
import com.example.testandroidsuperhero.data.model.ResponseApi

class SuperHeroInfoRepository {

    suspend fun fetchSuperHeroById(id: Int): ResponseApi? {
        val call = getRetrofit().create(APIService::class.java)
            .getSuperHeroById("characters/$id?ts=1&apikey=$PUBLIC_KEY&hash=$HASH_KEY")
        return call.body()
    }
}