package com.example.vendeja.models.database


import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "product")
data class ProductDB (

    @PrimaryKey

    var id: String? = null,
    var description: String? = null,
    var imageUrl: String? = null,
    var price: Float? = 0f,
    var produto: String? = null,
    var rating: Float? = 0f
) : Parcelable
