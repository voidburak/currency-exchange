package com.currency.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyExchangeService {

    static Map<String, Double> currencyInfo = new HashMap<>();

    static {
        currencyInfo.put("USD-TRY", 20.0);
        currencyInfo.put("TRY-USD", 0.05);
    }

    public String exchangeCurrency(String baseCurrency,
                                   String targetCurrency,
                                   String amount) {

        String currencyPair = baseCurrency + "-" + targetCurrency;
        boolean containsCurrencyPair = currencyInfo.containsKey(currencyPair);
        if (containsCurrencyPair){
            Double rate = currencyInfo.get(currencyPair);
            double result = Double.parseDouble(amount) * rate;
            return String.valueOf(result);
        }

        String errorResult = "Currency Pair can not be found!";
        return errorResult;


    }
}
