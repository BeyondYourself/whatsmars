package org.hongxi.whatsmars.spring.dbrouter;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by shenhongxi on 16/7/16.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    public DynamicDataSource() {}

    protected Object determineCurrentLookupKey() {
        return DbContext.getDbKey(); // ThreadLocal
    }
}