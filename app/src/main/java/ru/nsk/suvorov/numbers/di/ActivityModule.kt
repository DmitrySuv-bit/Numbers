package ru.nsk.suvorov.numbers.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.nsk.suvorov.numbers.app.MainActivity
import ru.nsk.suvorov.numbers.di.scope.ActivityScope

@Module
interface ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
            PresentationModule::class
        ])
    fun mainActivityInjector(): MainActivity
}