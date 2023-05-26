package com.solvd.project.connectionpoolthreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Threads {
    private static final Logger logger = LogManager.getLogger(Threads.class);
    public static void main(String[] args) throws InterruptedException, ExecutionException, SQLException {
        // Two ways to create threads
        Runnable r1 = () -> logger.info("This is the runnable thread\n");
        Thread thread1 = new Thread(r1);
        thread1.start();
        Thread thread2 = new Thread(() -> {
            logger.info("This is from Thread class\n");
        });
        thread2.start();

        // Thread pool and ConnectionPool
        ConnectionPool pool = ConnectionPool.getInstance();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        List<Connection> connections = new ArrayList<>();
        for(int i = 0; i <= 5; i++) {
            Runnable runnable = () -> {
                logger.info("Gathering connections from pool");
            };
            Callable<Connection> call = pool::getConnection;
            connections.add(threadPoolExecutor.submit(call).get());
            threadPoolExecutor.execute(runnable);
        }

        threadPoolExecutor.shutdown();
        pool.closeAllConnections();

        // Use of Future
        logger.info("----------------\n");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "This is the Future element\n";
        });
        while(!future.isDone()) {
            logger.info("Task is still processing...\n");
            Thread.sleep(1000);
        }
        logger.info("Task is done. Getting result...\n");
        String result = future.get();
        logger.info("Here is result " + result + "\n");
        executorService.shutdown();



    }
}
