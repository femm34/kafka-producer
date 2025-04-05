package com.fecd.kafkaproducer.kafka.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Event <T> {
    private String id;
    private LocalDate date;
    private EventType type;
    private T data;
}