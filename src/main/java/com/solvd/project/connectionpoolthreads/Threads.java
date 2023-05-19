package com.solvd.project.connectionpoolthreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Threads {
    private static final Logger logger = LogManager.getLogger(Threads.class);
    public static void main(String[] args) throws SQLException {
        // Two ways to create threads
        Runnable r1 = () -> logger.info("This is the runnable thread\n");
        Thread thread1 = new Thread(r1);
        thread1.start();
        Thread thread2 = new Thread(() -> {
            logger.info("This is from Thread class\n");
        });
        thread2.start();

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(7);

        for(int i = 0; i <= 7; i++) {
            Runnable runnable = () -> logger.info("Executing the run() method\n");
            threadPoolExecutor.execute(runnable);
        }
        threadPoolExecutor.shutdown();


    }
}
