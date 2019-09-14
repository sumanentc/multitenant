package com.example.config.multitenant.database;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig, Long> {
    DataSourceConfig findByName(String name);
}
