package com.octoprice.android.adapter

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.octoprice.android.BR

data class RecyclerViewItem(
    val dataItem: Any,
    @LayoutRes val layoutId: Int,
    val variableId: Int,
    val viewModel: Any
) {
    fun bind(binding: ViewDataBinding) {
        binding.setVariable(variableId, dataItem)
        binding.setVariable(BR.viewModel, viewModel)
    }
}