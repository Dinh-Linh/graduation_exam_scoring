package com.example.exam_scoring.model.source.network

import com.example.exam_scoring.model.req.ClassesReq
import com.example.exam_scoring.model.req.ExamReq
import com.example.exam_scoring.model.req.LoginReq
import com.example.exam_scoring.model.req.ResultExamReq
import com.example.exam_scoring.model.res.ApiResponse
import com.example.exam_scoring.model.res.ClassesResponse
import com.example.exam_scoring.model.res.ExamResponse
import com.example.exam_scoring.model.res.ExamResultsRes
import com.example.exam_scoring.model.res.LoginResponse
import com.example.exam_scoring.model.res.UserDetailResponse
import com.example.exam_scoring.utils.constants.APIConstant
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {
    @POST(APIConstant.EndPoint.LOGIN)
    suspend fun login(@Body loginReq: LoginReq): ApiResponse<LoginResponse>

    @POST(APIConstant.EndPoint.CLASSES)
    suspend fun getListClass(
        @Body classesReq: ClassesReq,
        @Header("Authorization") token: String
    ): ApiResponse<ClassesResponse>

    @POST(APIConstant.EndPoint.EXAMS)
    suspend fun getExams(@Header("Authorization") token: String, @Body examReq: ExamReq) : ApiResponse<ExamResponse>

    @GET(APIConstant.EndPoint.DETAILS_USER)
    suspend fun getUserDetails(@Header("Authorization") token: String, @Path("id") id: String) : ApiResponse<UserDetailResponse>

    @POST(APIConstant.EndPoint.RESULTS)
    suspend fun getListResult(@Header("Authorization") token: String, @Body resultExamReq: ResultExamReq) : ApiResponse<ExamResultsRes>
}