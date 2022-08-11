package com.example.newyorktimes

import android.app.Application
import com.example.database.di.component.DataBaseComponent
import com.example.network.di.component.NetworkComponent

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        NetworkComponent.init()
        DataBaseComponent.init(context = this)

    }

}