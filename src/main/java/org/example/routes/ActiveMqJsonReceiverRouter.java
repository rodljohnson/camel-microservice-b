package org.example.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.example.model.CurrencyExchange;
import org.example.processor.CurrencyExchangeProcessor;
import org.example.transformer.CurrencyExchangeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqJsonReceiverRouter extends RouteBuilder {
    @Autowired
    CurrencyExchangeProcessor currencyExchangeProcessor;
    @Autowired
    CurrencyExchangeTransformer currencyExchangeTransformer;

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-json-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(currencyExchangeProcessor)
                .bean(currencyExchangeTransformer)
                .to("log:received-message-from-activemq-json-queue");
    }
}
