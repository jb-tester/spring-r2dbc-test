package com.mytests.spring.springr2dbctest;

import io.r2dbc.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
public class TransactionConfig {

    @Primary
    @Bean("r2dbcTransactionManager")
    public ReactiveTransactionManager r2dbcTransactionManager(ConnectionPool connectionPool) {
        return new R2dbcTransactionManager(connectionPool);
    }
}
