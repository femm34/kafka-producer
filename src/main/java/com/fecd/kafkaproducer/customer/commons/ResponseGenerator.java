package com.fecd.kafkaproducer.customer.commons;

import com.fecd.kafkaproducer.customer.constants.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseGenerator {
    public static ResponseEntity<GenericResponse> build(int code, String message, Object data, HttpStatus status) {
        return ResponseEntity.ok(GenericResponse.builder()
                .code(code)
                .data(data)
                .message(message)
                .status(status)
                .build());
    }
}
