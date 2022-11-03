package com.example.testandroidsuperhero.data.model

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("resourceURI") var resourceURI: String,
    @SerializedName("name") var name: String,
    @SerializedName("type") var type: String
)
