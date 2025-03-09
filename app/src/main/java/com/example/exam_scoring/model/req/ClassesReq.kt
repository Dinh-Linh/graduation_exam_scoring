package com.example.exam_scoring.model.req

data class ClassesReq(
    val searchingKeys : String ?= null,
    val pageNumber : Int ?= null,
    val pageSize: Int ?= null,
    val typeView : String ?= null,
)
