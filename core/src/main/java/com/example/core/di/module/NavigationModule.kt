package com.example.core.di.module

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.core.navigation.AppNavigator
import com.example.core.navigation.AppNavigatorImpl
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    @Provides
    fun provideNavController(context: Fragment): NavController {
        return context.findNavController()
    }

    @Provides
    fun provideNavigator(controller: NavController): AppNavigator {
        return AppNavigatorImpl(controller)
    }
}