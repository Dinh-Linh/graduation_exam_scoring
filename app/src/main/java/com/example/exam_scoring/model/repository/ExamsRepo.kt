package com.example.exam_scoring.model.repository

import com.example.exam_scoring.base.BaseRepository
import com.example.exam_scoring.base.DataState
import com.example.exam_scoring.model.req.ExamReq
import com.example.exam_scoring.model.res.ApiResponse
import com.example.exam_scoring.model.res.ExamResponse
import com.example.exam_scoring.model.source.network.APIService

class ExamsRepo(private val apiService: APIService) : BaseRepository() {
    suspend fun getExams(token : String, examReq: ExamReq) : DataState<ApiResponse<ExamResponse>>{
        return getResult {
            apiService.getExams(token, examReq)
        }
    }
}