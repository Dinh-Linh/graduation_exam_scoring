package com.example.exam_scoring.model.res

import com.fasterxml.jackson.annotation.JsonProperty

data class ExamResult(
    @JsonProperty("id") val id : String,
    @JsonProperty("examId") val examId : String,
    @JsonProperty("examineeId") val examineeId : String,
    @JsonProperty("examineeName") val examineeName: String,
    @JsonProperty("examineeCode") val examineeCode: String,
    @JsonProperty("executionAmount") val executionAmount: Int,
    @JsonProperty("averageScore") val averageScore : Double
)

data class ExamResultsRes(
    val content: List<ExamResult>
)
