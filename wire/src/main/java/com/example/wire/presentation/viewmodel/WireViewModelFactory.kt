package com.example.wire.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.ViewModelFactory
import com.example.core.navigation.AppNavigator
import com.example.wire.databasesource.WireDataBaseSource
import com.example.wire.repository.WireRepository
import dagger.Lazy
import javax.inject.Inject

class WireViewModelFactory @Inject constructor(
    private val repository: Lazy<WireRepository>,
    private val dataBaseSource: Lazy<WireDataBaseSource>,
    private val appNavigator: Lazy<AppNavigator>
) : ViewModelFactory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WireViewModel(repository.get(), dataBaseSource.get(), appNavigator.get()) as T
    }
}