package com.example.exam_scoring.model.req

data class ExamReq(
    val searchingKey: String ?= null,
    val typeView: String,
    val classCode : String,
    val pageNumber : Int,
    val pageSize : Int
)
