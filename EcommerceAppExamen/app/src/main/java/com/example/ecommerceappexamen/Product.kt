package com.example.ecommerceappexamen

data class Product(
    val name: String,
    val price: Double,
    val description: String,
    val category: String,
    val inStock: Boolean,
    val relatedProducts: List<String>
)
