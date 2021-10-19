package com.mytests.spring.springr2dbctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * *
 * <p>Created by irina on 10/19/2021.</p>
 * <p>Project: spring-r2dbc-test</p>
 * *
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public void findAll(){
        for (Customer customer : customerRepo.findAll().toIterable()) {
            System.out.println(customer.toString());
        }
    }
    public void findByCity(){
        for (Customer customer : customerRepo.findByCity("spb").toIterable()) {
            System.out.println(customer.toString());
        }
    }
}
