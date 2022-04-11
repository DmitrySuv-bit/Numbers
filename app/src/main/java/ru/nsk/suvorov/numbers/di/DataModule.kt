package ru.nsk.suvorov.numbers.di

import dagger.Module
import ru.nsk.suvorov.numbers.feature.numberfact.di.NumberFactDataModule

@Module(includes = [
	NumberFactDataModule::class,
])
interface DataModule