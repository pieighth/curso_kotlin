package com.example.vendeja.di.modules

import android.content.Context
import androidx.room.Room
import com.example.vendeja.models.database.AppDatabase
import dagger.Module
import dagger.Provides
import java.security.AccessControlContext
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesRoom(context: Context) : AppDatabase{
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "vendeja-db")
            .build()
    }
}

