package com.example.exam_scoring.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.exam_scoring.base.BaseAdapter
import com.example.exam_scoring.base.BaseViewHolder
import com.example.exam_scoring.databinding.ItemExamBinding
import com.example.exam_scoring.model.entity.Exams

class ExamsAdapter : BaseAdapter<Exams, ItemExamBinding>(ItemExamBinding::inflate) {
    override fun bindData(binding: ItemExamBinding, item: Exams, position: Int) {
        binding.testCode.text = item.examCode
        binding.testName.text = item.examName
    }

    override fun onItemClick(binding: ItemExamBinding, item: Exams, position: Int) {
        binding.itemTest.setOnClickListener {
            onClick?.invoke(item)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ItemExamBinding> {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemExamBinding.inflate(inflate, parent, false)
        return BaseViewHolder(binding)
    }
}