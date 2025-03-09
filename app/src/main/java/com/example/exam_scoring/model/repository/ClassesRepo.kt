package com.example.exam_scoring.model.repository

import com.example.exam_scoring.base.BaseRepository
import com.example.exam_scoring.base.DataState
import com.example.exam_scoring.model.req.ClassesReq
import com.example.exam_scoring.model.res.ApiResponse
import com.example.exam_scoring.model.res.ClassesResponse
import com.example.exam_scoring.model.source.network.APIService

class ClassesRepo(private val apiService: APIService) : BaseRepository() {
    suspend fun getListClass(classesReq : ClassesReq, token : String) : DataState<ApiResponse<ClassesResponse>>{
        return getResult {
            apiService.getListClass(classesReq, token)
        }
    }
}