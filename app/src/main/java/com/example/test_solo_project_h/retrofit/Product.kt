package com.example.test_solo_project_h.retrofit

data class Product (
    val id: Int,
    val name: String,
    val dateCreate: String,
    val description: String,
    val new: Boolean,
    val popular: Boolean,
    val image: Image,
    val user: String
)

data class Image(
    val id: Int,
    val name: String
)