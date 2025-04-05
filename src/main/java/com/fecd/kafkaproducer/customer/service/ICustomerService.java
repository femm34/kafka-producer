package com.fecd.kafkaproducer.customer.service;

import com.fecd.kafkaproducer.customer.model.Customer;

public interface ICustomerService {
    Customer save(Customer customer);
}
