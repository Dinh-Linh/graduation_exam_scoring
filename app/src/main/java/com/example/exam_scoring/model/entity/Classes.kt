package com.example.exam_scoring.model.entity

import java.io.Serializable
import java.util.Date

data class Classes(
    val id: String ?= null,
    val classCode : String,
    val className: String,
    val limitSlot : Int ?= null,
    val participationAmount : Int ?= null,
    val examineAmount: Int?= null,
    val createByName : String?= null,
    val createByEmail: String ?= null,
    val userEmails : List<String> ?= null,
    val createAt : Date ?= null,
    val updateAt : Date ?= null,
) : Serializable
