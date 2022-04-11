package ru.nsk.suvorov.numbers.feature.numberfact.data.network.api

import retrofit2.http.GET
import ru.nsk.suvorov.numbers.feature.numberfact.data.network.model.NumberFactModel

interface NumberFactApi {

	@GET("random/math?json")
	suspend fun getNumberFact(): NumberFactModel
}