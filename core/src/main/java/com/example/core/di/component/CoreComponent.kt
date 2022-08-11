package com.example.core.di.component

import androidx.fragment.app.Fragment
import com.example.core.di.module.NavigationModule
import com.example.core.navigation.AppNavigator
import dagger.BindsInstance
import dagger.Component

@Component(modules = [NavigationModule::class])
interface CoreComponent {

    companion object {
        fun init(frag: Fragment): CoreComponent {
            return DaggerCoreComponent.factory().create(frag)
        }
    }

    @Component.Factory
    interface CoreComponentFactory {
        fun create(@BindsInstance context: Fragment): CoreComponent
    }

    fun provideNavigator(): AppNavigator

}