package com.example.exam_scoring.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.exam_scoring.base.BaseViewModel
import com.example.exam_scoring.model.entity.Classes
import com.example.exam_scoring.model.repository.ClassesRepo
import com.example.exam_scoring.model.req.ClassesReq
import com.example.exam_scoring.model.source.network.APIService
import com.example.exam_scoring.model.source.network.RetrofitClient

class ClassViewModel : BaseViewModel() {
    private val classesRepo = ClassesRepo(
        RetrofitClient.getInstant().create(APIService::class.java)
    )

    private val _listClass = MutableLiveData<List<Classes>?>()
    val listClass : LiveData<List<Classes>?> get() = _listClass
    fun getListClass(classesReq: ClassesReq, token: String) {
        executeTask(
            request = {
                classesRepo.getListClass(classesReq, token)
            },
            onSuccess = {
                _listClass.value = it.data?.content
                Log.d("All Class: ", it.data.toString())
            },
            onError = { e ->
                e.message
            },
            showLoading = true
        )
    }
}