package com.solvd.project.connectionpoolthreads;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolApacheDBCP {
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("test:url");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setMinIdle(1);
        dataSource.setMaxIdle(5);
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    private ConnectionPoolApacheDBCP(){}
}
