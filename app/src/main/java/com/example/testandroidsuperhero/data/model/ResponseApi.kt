package com.example.testandroidsuperhero.data.model

import com.google.gson.annotations.SerializedName

data class ResponseApi(
    @SerializedName("code") var code: Int,
    @SerializedName("status") var status: String,
    @SerializedName("data") var data: Data
)
