package com.example.exam_scoring.model.source.local.data_fake

import com.example.exam_scoring.model.entity.Classes
import com.example.exam_scoring.model.entity.Exams
import com.example.exam_scoring.model.entity.Users
import com.example.exam_scoring.model.req.LoginReq

class FakeData {
    val listAccount = mutableListOf(
        LoginReq("dinhLinh1", "123456"),
        LoginReq("dinhLinh2", "123456"),
        LoginReq("dinhLinh3", "123456"),
        LoginReq("dinhLinh4", "123456"),
    )
    val listUser = mutableListOf(
        Users(
            "s1",
            "2021601234",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkEtbbn0EAO3oCOEuz5gsB82AHMXaraPmDBw&s",
            "Nguyễn Văn Toàn"
        ),
        Users(
            "s2",
            "2021602341",
            "https://cdn2.fptshop.com.vn/unsafe/1920x0/filters:quality(100)/2023_11_30_638369818773780255_hinh-nen-200.jpg",
            "Hoàng Mạnh Hùng"
        ),
        Users("s3", "2021609845", null, "Nguyễn Tất Thắng"),
        Users("s4", "2021602659", "https://mega.com.vn/media/news/0106_hinh-nen-4k-may-tinh24.jpg", "Đỗ Hùng Dũng"),
        Users("s5", "2021601198", null, "Nguyễn Hoàng Đức"),
    )
    /*val listExams = mutableListOf(
        Exams("e1", null, "Kiểm tra hàm số", students = listUser.takeLast(3)),
        Exams("e2", null, "Kiểm tra 15p chương 1", students = listUser.take(3)),
        Exams("e3", null, "Kiểm tra 1 tiết toán 12", students = listUser.take(2)),
        Exams("e4", null, "Kiểm tra 1 tiết ngữ văn 12", students = listUser.take(4)),
        Exams("e5", null, "Kiểm tra 15p ngữ văn 10", students = listUser.take(5)),
        Exams("e6", null, "Kiểm tra 1 tiết hoá 11", students = listUser.take(3)),
    )
    val listClass = mutableListOf(
        Classes("c1", null, "Lớp 11A1", exams = listExams.take(3)),
        Classes("c2", null, "Lớp 11A2", exams = listExams.take(2)),
        Classes("c3", null, "Lớp 11A3", exams = listExams.take(4)),
        Classes("c4", null, "Lớp 11A4", exams = listExams.takeLast(3)),
        Classes("c5", null, "Lớp 11A5", exams = listExams.take(2)),
    )*/

}

