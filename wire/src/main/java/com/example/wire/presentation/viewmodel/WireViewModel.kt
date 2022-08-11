package com.example.wire.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.core.navigation.AppNavigator
import com.example.core.viewmodel.BaseViewModel
import com.example.wire.databasesource.WireDataBaseSource
import com.example.wire.presentation.data.presentation.WireCategory
import com.example.wire.presentation.data.presentation.WireItem
import com.example.wire.presentation.data.presentation.WireSource
import com.example.wire.presentation.navigation.WireCoordinator
import com.example.wire.repository.WireRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

private const val ALL_SECTION_ITEM = "all"
private const val ALL_SECTION_NAME = "All"
private const val FIRST_ITEM_INDEX = 0

class WireViewModel(
    private val repository: WireRepository,
    private val dataBaseSource: WireDataBaseSource,
    private val appNavigator: AppNavigator
) : BaseViewModel<WireCoordinator>() {

    val updateCategoryList: MutableStateFlow<Pair<Int?, Int?>> = MutableStateFlow(Pair(null, null))
    val categoryList: MutableStateFlow<List<WireCategory>> = MutableStateFlow(emptyList())
    val contentList: MutableStateFlow<List<WireItem>> = MutableStateFlow(emptyList())

    private var sourceItem: WireSource = WireSource.ALL
    private var selectedSection: String = ALL_SECTION_ITEM

    fun getWireCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getWireCategories()
                .catch { error.emit(it) }
                .collect {
                    if (it.isEmpty()) {
                        isEmptyVisible.emit(true)
                    } else {
                        setAllCategoryToList(it)
                        getWireContent()
                    }
                }
        }
    }

    private suspend fun setAllCategoryToList(categories: List<WireCategory>) {
        val list = categories.toMutableList()
        list.add(FIRST_ITEM_INDEX, WireCategory(ALL_SECTION_ITEM, ALL_SECTION_NAME, true))
        categoryList.emit(list)
    }

    private fun getWireContent() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getWireContent(sourceItem.requestName, selectedSection)
                .catch {
                    error.emit(it)
                }
                .collect {
                    if (it.isEmpty()) {
                        isEmptyVisible.emit(true)
                    } else {
                        contentList.emit(it)
                    }
                }
        }
    }

    fun onCategoryClicked(categoryName: String) {
        updateCategoryItem(categoryName)
        viewModelScope.launch {
            categoryList.emit(categoryList.value)
        }
        getWireContent()
    }

    private fun updateCategoryItem(categoryName: String) {
        val currentList = categoryList.value
        currentList.find { it.section == categoryName }?.apply {
            if (section != selectedSection) {
                val previousCategory = changeSelectedCategory()
                isSelected = true
                selectedSection = section
                viewModelScope.launch(Dispatchers.IO) {
                    updateCategoryList.emit(
                        Pair(
                            currentList.indexOf(previousCategory),
                            currentList.indexOf(this@apply)
                        )
                    )
                }
            }
        }
        getWireContent()
    }

    private fun changeSelectedCategory(): WireCategory? {
        return categoryList.value.find { it.isSelected }?.apply {
            isSelected = false
        }
    }

    fun onItemClicked(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            contentList.value.find { it.id == id }?.let {
                dataBaseSource.updateWire(it)
            }
        }
        appNavigator.onDetailScreen(id)
    }
}