package com.example.exam_scoring.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.exam_scoring.base.BaseViewModel
import com.example.exam_scoring.model.entity.Exams
import com.example.exam_scoring.model.repository.ExamsRepo
import com.example.exam_scoring.model.req.ExamReq
import com.example.exam_scoring.model.source.network.APIService
import com.example.exam_scoring.model.source.network.RetrofitClient

class ExamViewModel : BaseViewModel() {
    private val examsRepo = ExamsRepo(
        RetrofitClient.getInstant().create(APIService::class.java)
    )

    private val _listExam = MutableLiveData<List<Exams>>()
    val listExam : LiveData<List<Exams>> get()  = _listExam

    fun getExams(token : String, examReq: ExamReq){
        executeTask(
            request = {
                examsRepo.getExams(token, examReq)
            },
            onSuccess = {
                _listExam.value =it.data?.content
            },
            onError = {e ->
                e.message
            },
            showLoading = true
        )
    }
}