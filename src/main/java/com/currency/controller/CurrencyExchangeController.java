package com.currency.controller;

import com.currency.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService; 



    @PostMapping
    public ResponseEntity<String> exchangeCurrency(@RequestParam String baseCurrency,
                                                   @RequestParam String targetCurrency,
                                                   @RequestParam String amount){

        String result = currencyExchangeService.exchangeCurrency(baseCurrency, targetCurrency, amount);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
