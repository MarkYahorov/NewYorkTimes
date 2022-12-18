package com.example.detail.presentation.navigation

import javax.inject.Inject

class DetailCoordinatorImpl @Inject constructor(override val navigator: DetailNavigator) :
    DetailCoordinator {
}