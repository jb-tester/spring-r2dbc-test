package com.mytests.spring.springr2dbctest;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * *
 * <p>Created by irina on 10/19/2021.</p>
 * <p>Project: spring-r2dbc-test</p>
 * *
 */
public interface CustomerRepo extends R2dbcRepository<Customer,Integer> {

    Flux<Customer> findByCity(String city);
}
