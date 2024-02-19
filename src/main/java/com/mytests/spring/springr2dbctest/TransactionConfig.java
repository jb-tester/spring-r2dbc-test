package com.mytests.spring.springr2dbctest;

import io.asyncer.r2dbc.mysql.MySqlConnectionFactoryProvider;
import io.r2dbc.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryOptionsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

import java.time.ZoneId;

@Configuration
public class TransactionConfig {

    @Primary
    @Bean("r2dbcTransactionManager")
    public ReactiveTransactionManager r2dbcTransactionManager(ConnectionPool connectionPool) {
        return new R2dbcTransactionManager(connectionPool);
    }
    @Bean
    public ConnectionFactoryOptionsBuilderCustomizer mysqlCustomizer() {
        return (builder) ->
                builder.option(MySqlConnectionFactoryProvider.SERVER_ZONE_ID, ZoneId.of(
                        "UTC"));
    }
}
