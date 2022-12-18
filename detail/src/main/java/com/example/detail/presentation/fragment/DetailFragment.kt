package com.example.detail.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.core.fragment.BaseFragment
import com.example.detail.databinding.FragmentDetailBinding
import com.example.detail.di.component.DetailComponent
import com.example.detail.presentation.adapter.WireItemImageAdapter
import com.example.detail.presentation.navigation.DetailCoordinator
import com.example.detail.presentation.viewmodel.DetailViewModel
import kotlinx.coroutines.launch


class DetailFragment : BaseFragment<FragmentDetailBinding, DetailCoordinator, DetailViewModel>() {

    private val args: DetailFragmentArgs by navArgs()

    private val imageAdapter by lazy {
        WireItemImageAdapter(Glide.with(requireContext()))
    }

    override fun clearComponent() {
        DetailComponent.clear()
    }

    override fun getViewModelClass(): Class<DetailViewModel> = DetailViewModel::class.java

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun injectDi() {
        DetailComponent.init(this).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.wireImageRecycler) {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        }

        viewModel.getDetail(args.id)

        lifecycleScope.launch {
            viewModel.detailFlow.collect {
                binding.wireItemTitle.text = it.title
                binding.wireItemShortDescription.text = it.shortDescription
                imageAdapter.submitList(it.imagesList)
            }
        }

        lifecycleScope.launch {
            viewModel.error.collect {
                Log.e("TAG", "error $it")
            }
        }
    }
}