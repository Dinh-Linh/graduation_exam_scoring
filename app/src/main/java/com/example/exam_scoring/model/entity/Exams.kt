package com.example.exam_scoring.model.entity

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize
import java.util.Date

@kotlinx.parcelize.Parcelize
data class Exams(
    @JsonProperty("id") val id: String,
    @JsonProperty("examCode") val examCode: String? = null,
    @JsonProperty("examName") val examName: String,
    @JsonProperty("description") val description: String? = null,
    @JsonProperty("classCode") val classCode: String,
    @JsonProperty("createdDate") val createdDate: Date? = null,
    @JsonProperty("updateDate") val updateDate: Date? = null,
    @JsonProperty("createBy") val createdBy: String? = null,
    @JsonProperty("updateBy") val updatedBy: String? = null,
) : Parcelable