package com.example.lithodemo.model

import com.google.gson.annotations.*

data class Category(
    @SerializedName("name")
    val title: String,
    @SerializedName("skus")
    val skus: List<Sku>
)

data class Sku(
    @SerializedName("barcode")
    val barcode: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("unit_price")
    val price: Long
)
