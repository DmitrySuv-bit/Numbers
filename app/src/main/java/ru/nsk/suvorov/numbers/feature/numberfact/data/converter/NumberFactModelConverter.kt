package ru.nsk.suvorov.numbers.feature.numberfact.data.converter

import ru.nsk.suvorov.numbers.feature.numberfact.data.network.model.NumberFactModel
import ru.nsk.suvorov.numbers.feature.numberfact.domain.model.NumberFact
import javax.inject.Inject

class NumberFactModelConverter @Inject constructor() {

    fun convert(from: NumberFactModel): NumberFact =
        NumberFact(
            text = from.text,
            found = from.found,
            number = from.number
        )
}