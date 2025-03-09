package com.example.exam_scoring.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.exam_scoring.R
import com.example.exam_scoring.base.BaseAdapter
import com.example.exam_scoring.base.BaseViewHolder
import com.example.exam_scoring.databinding.ItemExamResultsBinding
import com.example.exam_scoring.model.res.ExamResult

class ExamResultsAdapter : BaseAdapter<ExamResult, ItemExamResultsBinding>(ItemExamResultsBinding::inflate) {
    @SuppressLint("SetTextI18n")
    override fun bindData(binding: ItemExamResultsBinding, item: ExamResult, position: Int) {
        binding.studentName.text = item.examineeName
        binding.studentCode.text = item.examineeCode
        binding.resultExam.text = R.string.result.toString() + item.averageScore
    }

    override fun onItemClick(binding: ItemExamResultsBinding, item: ExamResult, position: Int) {
        binding.itemStudent.setOnClickListener {
            onClick?.invoke(item)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ItemExamResultsBinding> {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemExamResultsBinding.inflate(inflate, parent, false)
        return BaseViewHolder(binding)
    }

}