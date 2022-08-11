package com.example.detail.di.component

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.core.di.component.CoreComponent
import com.example.database.di.component.DataBaseComponent
import com.example.detail.di.DetailScope
import com.example.detail.di.module.DetailModule
import com.example.detail.presentation.fragment.DetailFragment
import dagger.Component

@DetailScope
@Component(
    modules = [DetailModule::class],
    dependencies = [CoreComponent::class, DataBaseComponent::class]
)
interface DetailComponent {

    companion object {
        private var component: DetailComponent? = null

        fun init(fragment: Fragment): DetailComponent {
            return component ?: DaggerDetailComponent.factory().create(
                dataBaseComponent = DataBaseComponent.init(fragment.requireContext()),
                coreComponent = CoreComponent.init(fragment)
            ).also {
                component = it
            }
        }

        fun clear() {
            component = null
        }
    }

    @Component.Factory
    interface DetailFactory {
        fun create(
            coreComponent: CoreComponent,
            dataBaseComponent: DataBaseComponent
        ): DetailComponent
    }

    fun inject(fragment: DetailFragment)
}