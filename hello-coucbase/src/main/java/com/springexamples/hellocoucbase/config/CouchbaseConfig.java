package com.springexamples.hellocoucbase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
    @Override
    public String getConnectionString() {
        return "127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "sahin";
    }

    @Override
    public String getPassword() {
        return "6259458";
    }

    @Override
    public String getBucketName() {
        return "hellobucket";
    }
}
