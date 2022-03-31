package ru.nsk.suvorov.numbers.feature.numberfact.domain.repository

import ru.nsk.suvorov.numbers.feature.numberfact.domain.model.NumberFact

interface NumberFactRepository {

    suspend fun getNumberFact(): NumberFact
}