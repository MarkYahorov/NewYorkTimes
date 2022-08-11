package com.example.core.navigation

import androidx.navigation.NavController
import com.example.core.data.AppRoutes
import com.example.navigation.CoreNavigationDirections

class AppNavigatorImpl(navController: NavController) : BaseNavigator(navController), AppNavigator {

    override fun onWireScreen() {
        navigateToScreenWithoutArgs(AppRoutes.Wire)
    }

    override fun onDetailScreen(id: String) {
        val action = CoreNavigationDirections.actionDetailFlow(id)
        navigateToScreenWithArgs(action)
    }
}