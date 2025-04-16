package org.bortnik.converter.domain.dto

import java.time.LocalDate

data class CurrencyResponse (
    val amount: Double,
    val base: String,
    val date: LocalDate,
    val rates: Map<String, Double>
)
