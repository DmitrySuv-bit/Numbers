package ru.nsk.suvorov.numbers.feature.numberfact.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import ru.nsk.suvorov.numbers.di.scope.AppScope
import ru.nsk.suvorov.numbers.di.scope.ViewModelKey
import ru.nsk.suvorov.numbers.feature.numberfact.data.datasource.NumberFactDataSource
import ru.nsk.suvorov.numbers.feature.numberfact.data.datasource.NumberFactDataSourceImpl
import ru.nsk.suvorov.numbers.feature.numberfact.data.network.api.NumberFactApi
import ru.nsk.suvorov.numbers.feature.numberfact.data.repository.NumberFactRepositoryImpl
import ru.nsk.suvorov.numbers.feature.numberfact.domain.repository.NumberFactRepository
import ru.nsk.suvorov.numbers.feature.numberfact.presentation.NumberFactViewModel

@Module
interface NumberFactDataModule {

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

@Module
interface NumberFactPresentationModule {

	@Binds
	@IntoMap
	@ViewModelKey(NumberFactViewModel::class)
	fun bindNumberFactViewModel(viewModel: NumberFactViewModel): ViewModel
}