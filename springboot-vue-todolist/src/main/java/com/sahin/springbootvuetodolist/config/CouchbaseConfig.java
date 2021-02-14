package com.sahin.springbootvuetodolist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "localhost";
    }

    @Override
    public String getUserName() {
        return "sahin";
    }

    @Override
    public String getPassword() {
        return "sahin123";
    }

    @Override
    public String getBucketName() {
        return "todo";
    }
}
