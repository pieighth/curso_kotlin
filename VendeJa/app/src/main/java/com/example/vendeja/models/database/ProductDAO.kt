package com.example.vendeja.models.database

import androidx.room.Dao
import androidx.room.Delete

@Dao
interface ProductDAO {

        @Delete
        fun deleteProduct(product: ProductDB)
}
