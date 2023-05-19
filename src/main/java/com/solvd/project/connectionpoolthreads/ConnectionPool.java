package com.solvd.project.connectionpoolthreads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConnectionPool {
    private String url;
    private String user;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections;
    private static final Integer POOL_SIZE = 5;

    public ConnectionPool(String url, String user, String password, List<Connection> pool) {
    }

    public static ConnectionPool create(String url, String user, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(POOL_SIZE);
        for(int i = 0; i < POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new ConnectionPool(url, user, password, pool);
    }
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }
    public Boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }
    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    public Integer getPoolSize() {
        return connectionPool.size() + usedConnections.size();
    }
    public void clear() throws SQLException {
        usedConnections.forEach(this::releaseConnection);
        for(Connection c : connectionPool) {
            c.close();
        }
        connectionPool.clear();
    }
}
