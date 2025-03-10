package com.example.exam_scoring.base

sealed class DataState<out T> {
    data class Success<T>(val data: T) : DataState<T>()
    data class Error(val ex : Exception) : DataState<Nothing>()
}