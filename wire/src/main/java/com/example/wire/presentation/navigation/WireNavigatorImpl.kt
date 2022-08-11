package com.example.wire.presentation.navigation

import androidx.navigation.NavController
import com.example.core.navigation.BaseNavigator
import javax.inject.Inject

class WireNavigatorImpl @Inject constructor(private val navController: NavController) :
    WireNavigator,
    BaseNavigator(navController) {

}