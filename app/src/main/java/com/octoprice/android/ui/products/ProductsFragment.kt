package com.octoprice.android.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.octoprice.android.databinding.FragmentProductsBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ProductsFragment : Fragment() {
    private val productsViewModel: ProductsViewModel by viewModel()
    private lateinit var binding: FragmentProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductsBinding.inflate(inflater, container, false)
            .also<@NonNull FragmentProductsBinding> {
                it.viewModel = productsViewModel
                it.lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        productsViewModel.navigateToProductDetail.observe(viewLifecycleOwner, {
            findNavController().navigate(ProductsFragmentDirections.productsToProductDetails(it))
        })

        handlePullToRefresh()
    }

    private fun handlePullToRefresh() {
        binding.pullToRefresh.setOnRefreshListener {
            productsViewModel.loadProducts()
        }

        productsViewModel.products.observe(viewLifecycleOwner,
            {
                binding.pullToRefresh.isRefreshing = false
            }
        )
    }

    override fun onResume() {
        super.onResume()
        binding.pullToRefresh.isRefreshing = true
        productsViewModel.loadProducts()
    }
}