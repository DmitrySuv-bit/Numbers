package ru.nsk.suvorov.numbers.feature.numberfact.data.network.model

data class NumberFactModel(
	val text: String,
	val found: Boolean,
	val number: Int,
)