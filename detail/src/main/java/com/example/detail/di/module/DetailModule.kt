package com.example.detail.di.module

import com.example.core.ViewModelFactory
import com.example.core.mapper.SingleMapper
import com.example.core.mapper.TwiceMapper
import com.example.database.daoprovider.DaoProvider
import com.example.database.data.ImageDto
import com.example.database.data.WireDetailDto
import com.example.database.databasetable.DetailDao
import com.example.detail.data.WireDetail
import com.example.detail.databasesource.DetailDataBaseSource
import com.example.detail.databasesource.DetailDataBaseSourceImpl
import com.example.detail.databasesource.mapper.WireDetailMapper
import com.example.detail.di.DetailScope
import com.example.detail.presentation.viewmodel.DetailViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DetailModule {

    companion object {
        @DetailScope
        @Provides
        fun provideDetailDao(daoProvider: DaoProvider): DetailDao {
            return daoProvider.getDao(DetailDao::class.java)
        }
    }

    @DetailScope
    @Binds
    fun bindsDetailMapper(mapper: WireDetailMapper): TwiceMapper<WireDetailDto, List<ImageDto>, WireDetail>

    @DetailScope
    @Binds
    fun bindViewModelFactory(factory: DetailViewModelFactory): ViewModelFactory

    @DetailScope
    @Binds
    fun bindDataBaseSource(dataBaseSourceImpl: DetailDataBaseSourceImpl): DetailDataBaseSource
}