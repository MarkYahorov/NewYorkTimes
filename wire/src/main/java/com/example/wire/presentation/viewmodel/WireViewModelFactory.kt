package com.example.wire.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.ViewModelFactory
import com.example.core.mapper.SingleMapper
import com.example.core.navigation.AppNavigator
import com.example.wire.domain.models.DomainCategory
import com.example.wire.domain.models.DomainWireItem
import com.example.wire.domain.repository.WireDataBaseSource
import com.example.wire.domain.repository.WireRepository
import com.example.wire.domain.usecase.WireUseCase
import com.example.wire.presentation.data.presentation.WireCategory
import com.example.wire.presentation.data.presentation.WireItem
import dagger.Lazy
import javax.inject.Inject

class WireViewModelFactory @Inject constructor(
    private val useCase: Lazy<WireUseCase>,
    private val categoryMapper: Lazy<SingleMapper<List<DomainCategory>, List<WireCategory>>>,
    private val contentMapper: Lazy<SingleMapper<List<DomainWireItem>, List<WireItem>>>,
    private val appNavigator: Lazy<AppNavigator>
) : ViewModelFactory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WireViewModel(
            useCase.get(),
            categoryMapper.get(),
            contentMapper.get(),
            appNavigator.get()
        ) as T
    }
}