package ru.nsk.suvorov.numbers.util.coroutines.scope

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LaunchBuilder(
	val coroutineScope: CoroutineScope,
	val body: suspend CoroutineScope.() -> Unit,
) {

	inline infix fun handle(crossinline handler: (Throwable) -> Unit): Job =
		coroutineScope.launch(
			context = CoroutineExceptionHandler { _, throwable -> handler(throwable) },
			block = body
		)
}