package com.example.detail.navigation

import javax.inject.Inject

class DetailCoordinatorImpl @Inject constructor(override val navigator: DetailNavigator) :
    DetailCoordinator {
}