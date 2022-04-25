package ru.nsk.suvorov.numbers.feature.numberfact.presentation

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.nsk.suvorov.numbers.app.BaseViewModel
import ru.nsk.suvorov.numbers.feature.numberfact.data.network.api.NumberFactApi
import javax.inject.Inject

class NumberFactViewModel @Inject constructor(
	private val repository: NumberFactApi,
) : BaseViewModel() {

	private val allList: List<String> = emptyList()

	private val _listFacts: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())

	val listFacts: StateFlow<List<String>> = _listFacts.asStateFlow()

	fun update() {
		launchTrying {
			val repo = repository.getNumberFact()

			_listFacts.value = _listFacts.value.plus(repo.text)
		} handle ::handleError
	}

	private fun handleError(error: Throwable) {
		Log.d("fsdsdf", error.message.toString())
	}
}