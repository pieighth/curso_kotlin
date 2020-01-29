package com.example.vendeja.models

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class Product(
    @JsonIgnore
    @JsonProperty("description")
    val description: String? = null,
    @JsonProperty("id")
    val id: String? = null,
    @JsonProperty("imageUrl")
    val imageUrl: String? = null,
    @JsonProperty("price")
    val price: Double? = null,
    @JsonProperty("produto")
    val produto: String? = null,
    @JsonProperty("rating")
    val rating: Double? = null
) :Parcelable