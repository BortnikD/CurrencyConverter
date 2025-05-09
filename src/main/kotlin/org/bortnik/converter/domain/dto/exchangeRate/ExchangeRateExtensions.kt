package org.bortnik.converter.domain.dto.exchangeRate

import org.bortnik.converter.domain.entities.ExchangeRate
import org.bortnik.converter.domain.dto.exchangeRate.ExchangeRate as ExchangeRateDTO

fun ExchangeRate.toDto() =
    ExchangeRateDTO(
        this.id,
        this.sessionId,
        this.currency,
        this.rate
    )

fun ExchangeRateDTO.toEntity() =
    ExchangeRate(
        sessionId = this.sessionId,
        currency = this.currency,
        rate = this.rate
    )