package com.example.test_solo_project_h.retrofit

import retrofit2.http.GET

interface ProductApi {
    @GET("/api/clients/2")
    suspend fun getProductById(): Product

    @GET("/api/photos")
    suspend fun getAllPhotos(): Photos
}