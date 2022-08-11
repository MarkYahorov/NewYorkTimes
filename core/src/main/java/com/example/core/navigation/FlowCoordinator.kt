package com.example.core.navigation

interface FlowCoordinator<N : Navigator> {

    val navigator: N

    fun onBackPressed() {
        navigator.popBackStack()
    }
}