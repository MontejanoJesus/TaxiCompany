package com.solvd.project.connectionpoolthreads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

    private static ConnectionPool instance;
    private static BlockingQueue<Connection> connectionPool;
    private final static Integer POOL_SIZE = 5;
    private static String dbUrl = "test";

    private ConnectionPool() {
        connectionPool = new LinkedBlockingQueue<>(POOL_SIZE) {
        };
    }

    public static synchronized ConnectionPool getInstance() throws SQLException, InterruptedException {
        if(instance == null) {
            instance = new ConnectionPool();
            for(int i = 0; i < POOL_SIZE; i++) {
                connectionPool.put(DriverManager.getConnection(dbUrl));
            }
        }
        return instance;
    }

    public synchronized Connection getConnection() throws SQLException, InterruptedException {
        return connectionPool.take();
    }
    public synchronized void closeAllConnections() throws SQLException {
        for(Connection c : connectionPool) {
            c.close();
        }
        connectionPool.clear();
    }
}
