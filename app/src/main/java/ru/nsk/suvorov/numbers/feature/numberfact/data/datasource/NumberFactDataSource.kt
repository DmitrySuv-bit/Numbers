package ru.nsk.suvorov.numbers.feature.numberfact.data.datasource

import ru.nsk.suvorov.numbers.feature.numberfact.data.network.api.NumberFactApi
import ru.nsk.suvorov.numbers.feature.numberfact.data.network.model.NumberFactModel
import javax.inject.Inject

interface NumberFactDataSource {

	suspend fun getNumberFact(): NumberFactModel
}

class NumberFactDataSourceImpl @Inject constructor(
	private val numberFactApi: NumberFactApi,
) : NumberFactDataSource {

	override suspend fun getNumberFact(): NumberFactModel =
		numberFactApi.getNumberFact()
}