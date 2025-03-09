package com.example.exam_scoring.model.res

import com.example.exam_scoring.model.entity.Classes

data class ClassesResponse(
    val content : List<Classes> ?= null
)
