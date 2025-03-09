package com.example.exam_scoring.model.repository

import com.example.exam_scoring.base.BaseRepository
import com.example.exam_scoring.base.DataState
import com.example.exam_scoring.model.req.ResultExamReq
import com.example.exam_scoring.model.res.ApiResponse
import com.example.exam_scoring.model.res.ExamResultsRes
import com.example.exam_scoring.model.res.UserDetailResponse
import com.example.exam_scoring.model.source.network.APIService

class ExamResultsRepo(private val apiService: APIService) : BaseRepository() {
    suspend fun getExamResult(token : String, resultExamReq: ResultExamReq) : DataState<ApiResponse<ExamResultsRes>>{
        return getResult {
            apiService.getListResult(token, resultExamReq)
        }
    }

    suspend fun getExamResultUser(token: String, idUser : String) : DataState<ApiResponse<UserDetailResponse>>{
        return getResult {
            apiService.getUserDetails(token, idUser)
        }
    }
}