package com.example.exam_scoring.model.req

data class ResultExamReq(
    val examId : String,
    val viewType : String ?= null,
    val examineeId : String ?= null,
    val pageSize : Int,
    val pageNumber : Int
)
