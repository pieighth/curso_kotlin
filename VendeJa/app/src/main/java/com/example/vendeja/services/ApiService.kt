package com.example.vendeja.services

import com.example.vendeja.models.Product
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("/products.json")
    fun get(): Observable<Map<String, Product>>
}