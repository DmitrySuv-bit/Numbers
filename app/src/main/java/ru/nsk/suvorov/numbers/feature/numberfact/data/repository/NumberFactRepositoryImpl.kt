package ru.nsk.suvorov.numbers.feature.numberfact.data.repository

import ru.nsk.suvorov.numbers.feature.numberfact.data.converter.NumberFactModelConverter
import ru.nsk.suvorov.numbers.feature.numberfact.data.datasource.NumberFactDataSource
import ru.nsk.suvorov.numbers.feature.numberfact.domain.model.NumberFact
import ru.nsk.suvorov.numbers.feature.numberfact.domain.repository.NumberFactRepository
import javax.inject.Inject

class NumberFactRepositoryImpl @Inject constructor(
	private val dataSource: NumberFactDataSource,
	private val numberFactModelConverter: NumberFactModelConverter,
) : NumberFactRepository {

	override suspend fun getNumberFact(): NumberFact {
		val numberFactModel = dataSource.getNumberFact()

		return numberFactModelConverter.convert(numberFactModel)
	}
}