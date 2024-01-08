package com.consumer.example.processor;

import com.consumer.example.entity.OrderHistory;
import com.consumer.example.repository.OrderHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.consumer.example.proto.OrderHistoryEvent;

@Component
@Slf4j
public class MsSqlSyncProcessor implements Processor {

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Override
    public void process(Exchange exchange) throws Exception {
        var OrderHistoryEvent = exchange.getIn().getBody(OrderHistoryEvent.class);
        OrderHistory orderHistory=OrderHistory.builder()
                .orderID(OrderHistoryEvent.getOrderId())
                .orderStatus(OrderHistoryEvent.getOrderStatus())
                .customerID(OrderHistoryEvent.getCustomerId())
                .orderName(OrderHistoryEvent.getOrderName())
                .operation(OrderHistoryEvent.getOperation())
                .build();
        orderHistoryRepository.save(orderHistory);
    }
}
