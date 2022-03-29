package ru.nsk.suvorov.numbers.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.nsk.suvorov.numbers.di.DaggerAppComponent

class MainApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent
            .factory()
            .create(this)
}