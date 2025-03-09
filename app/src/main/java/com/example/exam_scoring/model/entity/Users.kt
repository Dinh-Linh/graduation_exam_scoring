package com.example.exam_scoring.model.entity

import java.util.Date

data class Users(
    val id: String? = null,
    val code: String,
    val avatar: String? = null,
    val fullName: String,
    val phoneNumber: String? = null,
    val email: String? = null,
    val password: String? = null,
    val gender: Int? = null,
    val birthDay: Date? = null,
    val role: Int? = null,
    val isActive: Boolean? = null,
    val createAt: Date? = null,
    val updateAt: Date? = null,
    val latestActive: Date? = null,
    val premiumCode: String? = null,
    val googleAccountId: String? = null,
)
