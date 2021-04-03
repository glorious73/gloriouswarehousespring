package com.glorious73.gloriouswarehouse.dialect;

import org.springframework.data.jdbc.repository.config.DialectResolver;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.Optional;

public class SQLiteDialectResolver implements DialectResolver.JdbcDialectProvider {

    @Override
    public Optional<Dialect> getDialect(JdbcOperations jdbcOperations) {
        return Optional.empty();
    }
}
