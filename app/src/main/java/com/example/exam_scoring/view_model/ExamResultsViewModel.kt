package com.example.exam_scoring.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.exam_scoring.base.BaseViewModel
import com.example.exam_scoring.model.repository.ExamResultsRepo
import com.example.exam_scoring.model.req.ResultExamReq
import com.example.exam_scoring.model.res.ExamResult
import com.example.exam_scoring.model.res.UserDetailResponse
import com.example.exam_scoring.model.source.network.APIService
import com.example.exam_scoring.model.source.network.RetrofitClient

class ExamResultsViewModel : BaseViewModel() {
    private val examResultsRepo = ExamResultsRepo(
        RetrofitClient.getInstant().create(APIService::class.java)
    )

    private val _examResults = MutableLiveData<List<ExamResult>>()
    val examResult: LiveData<List<ExamResult>> get() = _examResults

    private val _userDetailsMap = MutableLiveData<List<Map<String, UserDetailResponse>>>()
    val userDetailsMap: LiveData<List<Map<String, UserDetailResponse>>> get() = _userDetailsMap

    fun fetchExamResults(token: String, resultExamReq: ResultExamReq) {
        executeTask(
            request = {
                examResultsRepo.getExamResult(token, resultExamReq)
            },
            onSuccess = {
                _examResults.value = it.data?.content
            },
            onError = {
                it.message
            },
            showLoading = true
        )
    }

    /*fun fetchExamResultUser(token : String, examResults : List<ExamResult>){
        executeTask(
            request = {
                examResults.forEach{exam ->
                    val examineeId = exam.examineeId
                    examResultsRepo.getExamResultUser(token, examineeId)
                }
            },
            onSuccess = {
                _userDetailsMap.value = it
            },
            onError = {
                it.message
            },
            showLoading = true
        )
    }*/
}