package com.example.vendeja.di.modules

import com.example.vendeja.features.product.ProductRepository
import com.example.vendeja.services.ApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(includes = [NetworkModule::class, DatabaseModule::class])
class RepositoryModule {

    @Provides
    @Reusable
    fun proviceProductRepository(apiService: ApiService) : ProductRepository {
        return ProductRepository(apiService)
    }
}
