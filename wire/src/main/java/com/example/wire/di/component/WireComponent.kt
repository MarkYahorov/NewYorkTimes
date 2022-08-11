package com.example.wire.di.component

import com.example.core.di.component.CoreComponent
import com.example.database.di.component.DataBaseComponent
import com.example.network.di.component.NetworkComponent
import com.example.wire.di.WireScope
import com.example.wire.di.module.WireModule
import com.example.wire.presentation.fragment.WireFragment
import dagger.Component

@WireScope
@Component(
    modules = [WireModule::class],
    dependencies = [NetworkComponent::class, CoreComponent::class, DataBaseComponent::class]
)
interface WireComponent {

    companion object {
        var component: WireComponent? = null

        fun create(fragment: WireFragment): WireComponent {
            return component ?: DaggerWireComponent.factory()
                .create(
                    NetworkComponent.init(),
                    CoreComponent.init(fragment),
                    DataBaseComponent.init(fragment.requireContext())
                )
                .also {
                    component = it
                }
        }

        fun clear() {
            component = null
        }
    }

    @Component.Factory
    interface WireComponentFactory {
        fun create(
            networkComponent: NetworkComponent,
            coreComponent: CoreComponent,
            dataBaseComponent: DataBaseComponent
        ): WireComponent
    }

    fun inject(fragment: WireFragment)
}