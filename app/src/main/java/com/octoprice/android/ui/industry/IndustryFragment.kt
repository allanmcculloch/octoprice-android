package com.octoprice.android.ui.industry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.octoprice.android.R
import org.koin.android.viewmodel.ext.android.viewModel

class IndustryFragment : Fragment() {

    private val industryViewModel: IndustryViewModel by viewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_industry, container, false)
        val textView: TextView = root.findViewById(R.id.text_industry)
        industryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}