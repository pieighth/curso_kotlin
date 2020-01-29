package com.example.vendeja.features.product

import com.example.vendeja.models.Product
import com.example.vendeja.services.ApiService
import io.reactivex.Observable
import javax.inject.Inject


class ProductRepository @Inject constructor(private val apiService: ApiService) {

    fun getProducts() : Observable<Map<String, Product>> {
        return apiService.get()
    }

}
