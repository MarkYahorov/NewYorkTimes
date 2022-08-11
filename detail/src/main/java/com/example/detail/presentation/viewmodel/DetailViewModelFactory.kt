package com.example.detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.ViewModelFactory
import com.example.detail.databasesource.DetailDataBaseSource
import dagger.Lazy
import javax.inject.Inject

class DetailViewModelFactory @Inject constructor(private val dataBaseSource: Lazy<DetailDataBaseSource>): ViewModelFactory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(dataBaseSource.get()) as T
    }
}