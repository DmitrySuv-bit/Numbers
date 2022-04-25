package ru.nsk.suvorov.numbers.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import ru.nsk.suvorov.numbers.util.coroutines.scope.LaunchBuilder
import ru.nsk.suvorov.numbers.util.coroutines.scope.async
import ru.nsk.suvorov.numbers.util.coroutines.scope.launch
import ru.nsk.suvorov.numbers.util.coroutines.scope.launchBuilderFrom

abstract class BaseViewModel : ViewModel() {

	val scope: CoroutineScope
		get() = viewModelScope

	protected fun launchTrying(block: suspend CoroutineScope.() -> Unit): LaunchBuilder =
		scope.launchBuilderFrom(block)

	protected fun launch(block: suspend CoroutineScope.() -> Unit): Job =
		scope.launch(block = block)

	protected fun <T> async(block: suspend CoroutineScope.() -> T): Deferred<T> =
		scope.async(block = block)
}