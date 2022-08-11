package com.example.database.di.module

import android.content.Context
import com.example.database.DataBaseCreator
import com.example.database.daoprovider.DaoProvider
import com.example.database.daoprovider.DaoProviderImpl
import com.example.database.nydatabase.NYDatabase
import dagger.Module
import dagger.Provides

@Module
object DataBaseModule {

    @Provides
    fun provideDataBaseCreator(context: Context): DataBaseCreator {
        return DataBaseCreator(context)
    }

    @Provides
    fun provideNYDataBase(creator: DataBaseCreator): NYDatabase {
        return creator.getDataBase()
    }

    @Provides
    fun provideDaoProvider(database: NYDatabase): DaoProvider {
        return DaoProviderImpl(database)
    }
}