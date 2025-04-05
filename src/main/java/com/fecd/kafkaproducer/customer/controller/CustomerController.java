package com.fecd.kafkaproducer.customer.controller;

import com.fecd.kafkaproducer.customer.commons.ResponseGenerator;
import com.fecd.kafkaproducer.customer.constants.ApiPath;
import com.fecd.kafkaproducer.customer.constants.GenericResponse;
import com.fecd.kafkaproducer.customer.model.Customer;
import com.fecd.kafkaproducer.customer.service.ICustomerService;
import com.fecd.kafkaproducer.customer.service.impl.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.API_ROOT + ApiPath.CUSTOMERS)
@RequiredArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;

    @PostMapping
    public ResponseEntity<GenericResponse> createCustomer(@RequestBody Customer customer) {
        Customer customerCreated = customerService.save(customer);
        return ResponseGenerator.build(200, "Customer created successfully", customerCreated, HttpStatus.CREATED);
    }
}
