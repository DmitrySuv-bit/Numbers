package ru.nsk.suvorov.numbers.di.scope

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Retention
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
