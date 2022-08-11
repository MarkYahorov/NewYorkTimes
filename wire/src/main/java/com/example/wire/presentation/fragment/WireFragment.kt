package com.example.wire.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.core.fragment.BaseFragment
import com.example.wire.databinding.WireFragmentBinding
import com.example.wire.di.component.WireComponent
import com.example.wire.presentation.adapters.WireCategoryAdapter
import com.example.wire.presentation.adapters.WireContentAdapter
import com.example.wire.presentation.navigation.WireCoordinator
import com.example.wire.presentation.viewmodel.WireViewModel
import kotlinx.coroutines.launch

class WireFragment : BaseFragment<WireFragmentBinding, WireCoordinator, WireViewModel>() {

    private val categoriesAdapter = WireCategoryAdapter {
        viewModel.onCategoryClicked(it)
    }

    private val itemAdapter by lazy {
        WireContentAdapter(
            onItemClicked = { id -> viewModel.onItemClicked(id) },
            glide = Glide.with(requireContext())
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        manageCategoryRecycler()
        manageContentRecycler()

        lifecycleScope.launch {
            viewModel.categoryList.collect {
                categoriesAdapter.submitList(it)
            }
        }
        lifecycleScope.launch {
            viewModel.contentList.collect {
                itemAdapter.submitList(it)
            }
        }
        lifecycleScope.launch {
            viewModel.isEmptyVisible.collect {
                binding.emptyState.root.isVisible = it
            }
        }
        lifecycleScope.launch {
            viewModel.error.collect {

            }
        }
        lifecycleScope.launch {
            viewModel.updateCategoryList.collect {
                categoriesAdapter.notifyItemChanged(it.first ?: 0)
                categoriesAdapter.notifyItemChanged(it.second ?: 0)
            }
        }
    }

    private fun manageContentRecycler() {
        with(binding.wireItemsRecycler) {
            adapter = itemAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun manageCategoryRecycler() {
        with(binding.wireCategoryRecycler) {
            adapter = categoriesAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.getWireCategories()
    }

    override fun getViewModelClass(): Class<WireViewModel> = WireViewModel::class.java

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?): WireFragmentBinding {
        return WireFragmentBinding.inflate(inflater, container, false)
    }

    override fun injectDi() {
        WireComponent.create(this).inject(this)
    }

    override fun clearComponent() {
        WireComponent.clear()
    }
}