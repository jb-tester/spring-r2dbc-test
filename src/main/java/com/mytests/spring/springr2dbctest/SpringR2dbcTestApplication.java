package com.mytests.spring.springr2dbctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringR2dbcTestApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(SpringR2dbcTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------");
        customerService.findAll();
        System.out.println("--------");
        customerService.findByCity();
        System.out.println("--------");
        customerService.findLastNamesByCity();
        System.out.println("--------");
        customerService.checkStreetExisting();
        System.out.println("--------");
        customerService.findByStreet();
        System.out.println("--------");
        customerService.findBySpel();
        System.out.println("--------");
    }
}
