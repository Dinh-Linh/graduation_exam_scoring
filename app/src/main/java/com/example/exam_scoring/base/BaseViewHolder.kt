package com.example.exam_scoring.base

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

class BaseViewHolder<VB: ViewBinding>(val binding: VB): ViewHolder(binding.root) {
}