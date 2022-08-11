package com.example.detail.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.core.viewmodel.BaseViewModel
import com.example.detail.data.WireDetail
import com.example.detail.databasesource.DetailDataBaseSource
import com.example.detail.navigation.DetailCoordinator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DetailViewModel(private val dataBaseSource: DetailDataBaseSource) :
    BaseViewModel<DetailCoordinator>() {

    val detailFlow: MutableStateFlow<WireDetail> = MutableStateFlow(WireDetail())

    fun getDetail(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dataBaseSource.getWireDetail(id)
                .catch {
                    error.emit(it)
                }
                .collect { detail ->
                    detailFlow.emit(detail)
                }
        }
    }

}