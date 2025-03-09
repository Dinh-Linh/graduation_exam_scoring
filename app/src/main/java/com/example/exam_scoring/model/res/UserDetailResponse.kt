package com.example.exam_scoring.model.res

import com.fasterxml.jackson.annotation.JsonProperty

data class UserDetailResponse(
    @JsonProperty("id") val id : String,
    @JsonProperty("avatar") val avatar : String ?= null,
    @JsonProperty("fullName") val fullName : String,
    @JsonProperty("code") val code : String
)
