package com.fecd.kafkaproducer.customer.constants;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {
    private int code;
    private String message;
    private Object data;
    private HttpStatus status;
}
