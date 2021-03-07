package com.octoprice.android.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import org.koin.android.viewmodel.ext.android.viewModel
import com.octoprice.android.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : Fragment() {
    private val productDetailsViewModel: ProductDetailsViewModel by viewModel()
    private val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentProductDetailsBinding.inflate(inflater, container, false)
            .also<@NonNull FragmentProductDetailsBinding> {
                it.viewModel = productDetailsViewModel
                it.lifecycleOwner = viewLifecycleOwner
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productDetailsViewModel.loadProduct(args.product)
    }
}