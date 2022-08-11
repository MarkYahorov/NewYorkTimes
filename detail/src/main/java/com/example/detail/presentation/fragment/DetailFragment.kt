package com.example.detail.presentation.fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.core.fragment.BaseFragment
import com.example.detail.databinding.FragmentDetailBinding
import com.example.detail.di.component.DetailComponent
import com.example.detail.navigation.DetailCoordinator
import com.example.detail.presentation.viewmodel.DetailViewModel
import kotlinx.coroutines.launch


class DetailFragment : BaseFragment<FragmentDetailBinding, DetailCoordinator, DetailViewModel>() {

    private val args: DetailFragmentArgs by navArgs()

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

    override fun onStart() {
        super.onStart()

        viewModel.getDetail(args.id)

        lifecycleScope.launch {
            viewModel.detailFlow.collect {
                Log.e("TAG", "success $it")
            }
        }

        lifecycleScope.launch {
            viewModel.error.collect {
                Log.e("TAG", "error $it")
            }
        }
    }

}