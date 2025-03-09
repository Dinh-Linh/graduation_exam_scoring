package com.example.exam_scoring.utils.constants

object APIConstant {
    const val BASE_URL = "http://183.87.41.185:1910/"
    object TimeOut {
        const val CONNECT_TIME_OUT = 20L
    }
    object EndPoint{
        const val UPLOAD_ASSIGNMENT = ""
        const val CLASSES = "api/classes/all"
        const val DETAILS_CLASS = "api/classes/{id}"
        const val DETAILS_USER = "api/users/user/{id}"
        const val RESULTS = "api/exam/results"
        const val EXAMS = "api/exam/list"
        const val STUDENTS = "api/users/all"
        const val LOGIN = "api/auth/login"
    }
}