package com.octoprice.android.ui.industry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import com.octoprice.android.databinding.FragmentIndustryBinding
import org.koin.android.viewmodel.ext.android.viewModel

class IndustryFragment : Fragment() {
    private val industryViewModel: IndustryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentIndustryBinding.inflate(inflater, container, false)
            .also<@NonNull FragmentIndustryBinding> {
                it.viewModel = industryViewModel
                it.lifecycleOwner = viewLifecycleOwner
            }.root
    }
}