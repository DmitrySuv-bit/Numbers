package ru.nsk.suvorov.numbers.di

import dagger.Component
import dagger.android.AndroidInjector
import ru.nsk.suvorov.numbers.app.MainApplication
import ru.nsk.suvorov.numbers.di.scope.AppScope

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<MainApplication>
}