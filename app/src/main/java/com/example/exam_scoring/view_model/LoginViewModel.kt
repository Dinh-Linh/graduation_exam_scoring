package com.example.exam_scoring.view_model

import com.example.exam_scoring.base.BaseViewModel
import com.example.exam_scoring.model.repository.LoginRepo
import com.example.exam_scoring.model.req.LoginReq
import com.example.exam_scoring.model.res.ApiResponse
import com.example.exam_scoring.model.res.LoginResponse
import com.example.exam_scoring.model.source.network.APIService
import com.example.exam_scoring.model.source.network.RetrofitClient

class LoginViewModel : BaseViewModel() {
    private val loginRepo = LoginRepo(RetrofitClient.getInstant().create(APIService::class.java))
    fun login(loginReq: LoginReq, onLoginSuccess: (ApiResponse<LoginResponse>) -> Unit) {
        executeTask(
            request = {
                loginRepo.login(loginReq)
            },
            onSuccess = {
                res -> onLoginSuccess(res) },
            onError = {e ->
                e.message
            },
            showLoading = true
        )
    }
}