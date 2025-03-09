package com.example.exam_scoring.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.exam_scoring.base.BaseAdapter
import com.example.exam_scoring.base.BaseViewHolder
import com.example.exam_scoring.databinding.ItemClassBinding
import com.example.exam_scoring.model.entity.Classes

class ClassesAdapter() : BaseAdapter<Classes, ItemClassBinding>(ItemClassBinding::inflate) {
    override fun bindData(binding: ItemClassBinding, item: Classes, position: Int) {
        binding.className.text = item.className
        binding.classCode.text = item.classCode
    }

    override fun onItemClick(binding: ItemClassBinding, item: Classes, position: Int) {
        binding.classN.setOnClickListener {
            onClick?.invoke(item)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ItemClassBinding> {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemClassBinding.inflate(inflate, parent, false)
        return BaseViewHolder(binding)
    }

}