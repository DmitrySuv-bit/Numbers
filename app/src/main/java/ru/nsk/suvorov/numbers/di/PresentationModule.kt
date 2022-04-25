package ru.nsk.suvorov.numbers.di

import dagger.Module
import ru.nsk.suvorov.numbers.feature.numberfact.di.NumberFactPresentationModule

@Module(includes = [
	NumberFactPresentationModule::class,
])
interface PresentationModule