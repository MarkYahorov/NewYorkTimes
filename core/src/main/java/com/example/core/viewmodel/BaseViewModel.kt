package com.example.core.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.navigation.FlowCoordinator
import com.example.core.navigation.Navigator
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel<Coordinator : FlowCoordinator<*>>() :
    ViewModel() {

    @Inject
    lateinit var coordinator: Coordinator

    val error: MutableStateFlow<Throwable?> = MutableStateFlow(null)
    val isProgressVisible: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isEmptyVisible: MutableStateFlow<Boolean> = MutableStateFlow(false)
}
