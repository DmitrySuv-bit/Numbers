package ru.nsk.suvorov.numbers.feature.numberfact.domain.model

data class NumberFact(
	val text: String,
	val found: Boolean,
	val number: Int,
)