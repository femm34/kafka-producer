package com.fecd.kafkaproducer.customer.service.impl;

import com.fecd.kafkaproducer.customer.model.Customer;
import com.fecd.kafkaproducer.customer.service.ICustomerService;
import com.fecd.kafkaproducer.kafka.models.Event;
import com.fecd.kafkaproducer.kafka.models.EventType;
import com.fecd.kafkaproducer.kafka.topic.TopicNames;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService implements ICustomerService {
    private final KafkaTemplate<String, Event<?>> kafkaProducer;

    @Override
    public Customer save(Customer customer) {
        log.info("save customer: {}", customer.getUsername());

        kafkaProducer.send(TopicNames.CUSTOMERS.name(), Event.builder()
                .data(customer)
                .id(UUID.randomUUID().toString())
                .type(EventType.CREATED)
                .date(LocalDate.now())
                .build());
        return customer;
    }
}
