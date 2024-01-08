package com.consumer.example.route;

import com.consumer.example.processor.MsSqlSyncProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaRouteBuilder extends RouteBuilder {

    @Autowired
    MsSqlSyncProcessor msSqlSyncProcessor;

    @Override
    public void configure() throws Exception {
        from("kafka:ORDER_HISTORY_TRACKING")
                .log("${body}")
                .process(msSqlSyncProcessor)
                .to("log:received successfully");
    }
}
