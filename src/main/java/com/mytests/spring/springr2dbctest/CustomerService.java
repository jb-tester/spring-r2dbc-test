package com.mytests.spring.springr2dbctest;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        for (Customer customer : Flux.from(customerRepo.findByCity("spb")).toIterable()) {
            System.out.println(customer.toString());
        }
    }
    public void findLastNamesByCity(){
        for (String name : customerRepo.findLastNameByCity("spb").toIterable()) {
            System.out.println(name);
        }
        }
    public void checkStreetExisting(){

        Mono<Boolean> rez = customerRepo.existsByStreetContains("gavrskaya");
        System.out.println(rez.block());
    }
    public void findByStreet(){
        Publisher<String> pattern = customerRepo.findStreetByName("irina");
        System.out.println(Mono.from(pattern).block());
        for (Customer customer : customerRepo.findByStreet(Mono.from(pattern)).toIterable()) {
            System.out.println(customer.toString());
        }
    }

    public void findBySpel(){
        for (Customer customer : customerRepo.findByQueryWithSpELExpression("pogorelova").toIterable()) {
            System.out.println(customer.toString());
        }
    }
    // https://youtrack.jetbrains.com/issue/IDEA-346385
    @Transactional(transactionManager = "r2dbcTransactionManager")
    public Mono<Customer> addNew(){
        int id = customerRepo.findAll().last().block().getId();
        Customer customer = new Customer(id + 1, "Vasya", "Pupkin");
        customerRepo.save(customer);
        return Mono.just(customer);
    }
    }

