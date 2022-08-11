package com.example.database.di.component

import android.content.Context
import com.example.database.daoprovider.DaoProvider
import com.example.database.di.module.DataBaseModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataBaseModule::class])
interface DataBaseComponent {

    companion object {
        private var component: DataBaseComponent? = null

        fun init(context: Context): DataBaseComponent {
            return component ?: DaggerDataBaseComponent.factory().create(context)
        }
    }

    @Component.Factory
    interface DataBaseFactory {
        fun create(@BindsInstance context: Context): DataBaseComponent
    }

    fun provideDaoProvider(): DaoProvider
}