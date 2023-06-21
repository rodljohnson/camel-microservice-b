package org.example.routes;

import org.apache.camel.builder.RouteBuilder;
import org.example.model.CurrencyExchange;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqXmlReceiverRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-xml-queue")
                .unmarshal()
                .jacksonXml(CurrencyExchange.class)
                .to("log:received-message-from-activemq-xml-queue");
    }

}
