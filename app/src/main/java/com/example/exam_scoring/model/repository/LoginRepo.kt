package com.example.exam_scoring.model.repository

import com.example.exam_scoring.base.BaseRepository
import com.example.exam_scoring.base.DataState
import com.example.exam_scoring.model.req.LoginReq
import com.example.exam_scoring.model.res.ApiResponse
import com.example.exam_scoring.model.res.LoginResponse
import com.example.exam_scoring.model.source.network.APIService

class LoginRepo(private val apiService: APIService) : BaseRepository() {
    suspend fun login(loginReq: LoginReq) : DataState<ApiResponse<LoginResponse>> {
        return getResult {
            apiService.login(loginReq)
        }
    }
}