package com.example.vendeja.models.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [ProductDB::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDAO(): ProductDAO
}