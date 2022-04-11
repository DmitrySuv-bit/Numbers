package ru.nsk.suvorov.numbers.feature.numberfact.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import ru.nsk.suvorov.numbers.di.scope.AppScope
import ru.nsk.suvorov.numbers.feature.numberfact.data.datasource.NumberFactDataSource
import ru.nsk.suvorov.numbers.feature.numberfact.data.datasource.NumberFactDataSourceImpl
import ru.nsk.suvorov.numbers.feature.numberfact.data.network.api.NumberFactApi
import ru.nsk.suvorov.numbers.feature.numberfact.data.repository.NumberFactRepositoryImpl
import ru.nsk.suvorov.numbers.feature.numberfact.domain.repository.NumberFactRepository

@Module
interface NumberFactDataModule{

    companion object {

        @Provides
        @AppScope
        fun provideNumberFactApi(retrofit: Retrofit): NumberFactApi =
            retrofit.create(NumberFactApi::class.java)
    }

    @Binds
    @Reusable
    fun bindNumberFactDataSource(numberFactDataSourceImpl: NumberFactDataSourceImpl): NumberFactDataSource

    @Binds
    @Reusable
    fun bindNumberFactRepository(numbersRepositoryImpl: NumberFactRepositoryImpl): NumberFactRepository
}