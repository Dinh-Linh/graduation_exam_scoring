package com.example.exam_scoring.model.res

data class ApiResponse<T>(
    val status: String,
    val data: T?
)
