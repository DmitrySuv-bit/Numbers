package ru.nsk.suvorov.numbers.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import ru.nsk.suvorov.numbers.app.MainApplication
import ru.nsk.suvorov.numbers.data.network.di.NetworkModule
import ru.nsk.suvorov.numbers.di.scope.AppScope

@Module(
	includes = [
		AndroidInjectionModule::class,

		NetworkModule::class,
		DataModule::class,
		ActivityModule::class
	]
)
interface AppModule {

	@Binds
	@AppScope
	fun bindContext(app: MainApplication): Context

	@Binds
	@AppScope
	fun bindApplication(app: MainApplication): Application
}