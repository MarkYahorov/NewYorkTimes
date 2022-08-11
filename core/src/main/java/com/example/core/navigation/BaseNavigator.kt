package com.example.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.example.core.data.Route

abstract class BaseNavigator(private val navController: NavController) {

    fun navigateToScreenWithoutArgs(route: Route) {
        navController.navigate(route.title)
    }

    fun navigateToScreenWithArgs(directions: NavDirections) {
        navController.navigate(directions)
    }

    fun popBackStack() {
        navController.popBackStack()
    }
}