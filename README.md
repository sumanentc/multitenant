# spring-boot-multitenant
This is a Spring Boot multi-tenant sample application which supports all multiple-tenancy models. By default multi schema model is enabled.</br>
Multi-Tenancy model is enabled using  [Hibernate multi-tenancy support](https://docs.jboss.org/hibernate/orm/4.2/devguide/en-US/html/ch16.html).</br>

There are multiple well-known strategies to implement this architecture, ranging from highly isolated (like single-tenant) to everything shared.</br>
We can implement multi-tenancy using any of the following approaches:</br>
1. Database per Tenant: Each Tenant has its own database and is isolated from other tenants.
2. Shared Database, Shared Schema: All Tenants share a database and tables. Every table has a Column with the Tenant Identifier, that shows the owner of the row.
3. Shared Database, Separate Schema: All Tenants share a database, but have their own database schemas and tables.

By Default Shared Database, Separate Schema approach is enabled. It works with JdbcTemplate also which is not natively supported by Spring Multi-Tenancy. When using Multi-tenancy in Spring Boot Table needs to be created externally.
Auto table creation needs to be turned off. We will use Public Schema as the default schema. The DDL to create the table are present in DDL.sql in resources folder. 
## Compile and package
Being Maven centric, you can compile and package it without tests using:
```
mvn clean package -Dmaven.test.skip=true
```
Once you have your jar file, you can run it.

## Run it

To run it you can go to the Maven target folder generated and execute the following command:
```
java -jar multitenant-XXX.jar
```

## Testing

Once started you can go and request the data using different tenants :

* `curl -X POST   http://localhost:8080/ -H 'Content-Type: application/json' -H 'X-TenantID: test1' -d '{"name":"Mumbai"}'`

* `curl -X POST   http://localhost:8080/ -H 'Content-Type: application/json' -H 'X-TenantID: test2' -d '{"name":"Kolkata"}'`

*  `curl -X GET   http://localhost:8080/ -H 'Content-Type: application/json' -H 'X-TenantID: test1'`

* `curl -X GET   http://localhost:8080/ -H 'Content-Type: application/json' -H 'X-TenantID: test2' `