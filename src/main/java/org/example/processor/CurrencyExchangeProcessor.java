package org.example.processor;

import org.example.model.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeProcessor {
    Logger logger = LoggerFactory.getLogger(CurrencyExchangeProcessor.class);
    public void processMessage(CurrencyExchange currencyExchange) {
        logger.info("Do some processing with currencyExchange.getConversionMultiple() value which is {}", currencyExchange.getConversionMultiple());
    }
}
