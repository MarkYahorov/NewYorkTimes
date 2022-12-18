package com.example.detail.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.core.mapper.SingleMapper
import com.example.core.viewmodel.BaseViewModel
import com.example.detail.presentation.data.WireDetail
import com.example.detail.domain.DetailDataBaseSource
import com.example.detail.domain.WireDetailUseCase
import com.example.detail.domain.models.DomainWireItem
import com.example.detail.presentation.navigation.DetailCoordinator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DetailViewModel(
    private val wireDetailUseCase: WireDetailUseCase,
    private val wireDetailMapper: SingleMapper<DomainWireItem, WireDetail>
) : BaseViewModel<DetailCoordinator>() {

    val detailFlow: MutableStateFlow<WireDetail> = MutableStateFlow(WireDetail())

    fun getDetail(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            wireDetailUseCase.getWireDetailItem(id)
                .map { wireDetailMapper.map(it) }
                .catch {
                    error.emit(it)
                }
                .collect { detail ->
                    detailFlow.emit(detail)
                }
        }
    }

}