package com.example.config.multitenant.database;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static com.example.constant.MultiTenantConstants.DEFAULT_TENANT_ID;

//@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {
    @Autowired
    private DataSource defaultDS;

    @Autowired
    private ApplicationContext context;

    private Map<String, DataSource> map = new HashMap<>();

    boolean init = false;

    //@PostConstruct
    public void load() {
        map.put(DEFAULT_TENANT_ID, defaultDS);
    }

    @Override
    protected DataSource selectAnyDataSource() {
        return map.get(DEFAULT_TENANT_ID);
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        if (!init) {
            init = true;
            TenantDataSource tenantDataSource = context.getBean(TenantDataSource.class);
            map.putAll(tenantDataSource.getAll());
        }
        return map.get(tenantIdentifier) != null ? map.get(tenantIdentifier) : map.get(DEFAULT_TENANT_ID);
    }
}
