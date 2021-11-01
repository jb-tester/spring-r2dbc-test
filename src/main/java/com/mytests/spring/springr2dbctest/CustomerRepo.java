package com.mytests.spring.springr2dbctest;

import org.reactivestreams.Publisher;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * *
 * <p>Created by irina on 10/19/2021.</p>
 * <p>Project: spring-r2dbc-test</p>
 * *
 */
public interface CustomerRepo extends R2dbcRepository<Customer,Integer> {

    Flux<Customer> findByStreet(Publisher<String> street);
    Publisher<Customer> findByCity(String city);
    Mono<Customer> findFirstByFirstName(String name);
    Mono<Boolean> existsByStreetContains(String street);

    @Query("select customer.lastName from Customer customer where customer.city = :city")
    Flux<String> findLastNameByCity(@Param("city") String city);

    @Query("select c.street from Customer c where c.firstName= :name")
    Publisher<String> findStreetByName(@Param("name") String name);

    @Query("SELECT * FROM customer WHERE lastname = :#{[0]}")
    Flux<Customer> findByQueryWithSpELExpression(String lastname);
}
