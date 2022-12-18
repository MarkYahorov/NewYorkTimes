package com.example.detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.ViewModelFactory
import com.example.core.mapper.SingleMapper
import com.example.detail.domain.WireDetailUseCase
import com.example.detail.domain.models.DomainWireItem
import com.example.detail.presentation.data.WireDetail
import dagger.Lazy
import javax.inject.Inject

class DetailViewModelFactory @Inject constructor(
    private val useCase: Lazy<WireDetailUseCase>,
    private val wireDetailMapper: Lazy<SingleMapper<DomainWireItem, WireDetail>>
) : ViewModelFactory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(useCase.get(), wireDetailMapper.get()) as T
    }
}