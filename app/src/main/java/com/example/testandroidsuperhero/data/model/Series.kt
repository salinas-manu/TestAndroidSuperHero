package com.example.testandroidsuperhero.data.model

import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("available") var available: Int,
    @SerializedName("collectionURI") var collectionURI: String,
    @SerializedName("items") var items: List<Items>,
    @SerializedName("returned") var returned: Int
)
