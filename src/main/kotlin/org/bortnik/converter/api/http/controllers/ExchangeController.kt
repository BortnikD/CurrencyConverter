package org.bortnik.converter.api.http.controllers

import org.bortnik.converter.domain.dto.ExchangeSessionWithRates
import org.bortnik.converter.domain.exceptions.currency.InvalidRequestException
import org.bortnik.converter.usecase.CreateExchangeCurrencyUseCase
import org.bortnik.converter.usecase.GetExchangeCurrencyUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/exchange")
class ExchangeController(
    private val getExchangeUseCase: GetExchangeCurrencyUseCase,
    private val createExchangeCurrencyUseCase: CreateExchangeCurrencyUseCase
) {

    @GetMapping("/{currencyName}")
    suspend fun getExchangeSessionWithRates(
        @PathVariable currencyName: String
    ): ExchangeSessionWithRates {
        if(currencyName.length != 3) {
            throw InvalidRequestException("length currency name must be equal 3")
        }
        return getExchangeUseCase.findByBaseCurrencyOrderByDateDesc(currencyName.uppercase())
    }

    @PostMapping
    suspend fun setExchangeSessionWithRates(
        @RequestBody sessionWithRates: ExchangeSessionWithRates
    ): ExchangeSessionWithRates {
        return createExchangeCurrencyUseCase.saveSessionWithRates(sessionWithRates)
    }

}
