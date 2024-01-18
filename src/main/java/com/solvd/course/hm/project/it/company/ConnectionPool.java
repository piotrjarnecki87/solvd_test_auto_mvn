package com.solvd.course.hm.project.it.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class ConnectionPool {
    private static ConnectionPool instance;
    private static BlockingQueue<CompletableFuture<DatabaseConnection>> pool;
    private static int poolSize = 5;
    private static Semaphore semaphore = new Semaphore(poolSize);
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    static synchronized void initializePool() {
        if (pool == null) {
            pool = new LinkedBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                pool.add(CompletableFuture.completedFuture(new DatabaseConnection()));
            }
        }
    }

    public static CompletableFuture<DatabaseConnection> getConnectionAsync() {
        initializePool();
        CompletableFuture<DatabaseConnection> future = new CompletableFuture<>();

        try {
            semaphore.acquire();
            CompletableFuture.runAsync(() -> {
                try {
                    DatabaseConnection connection = pool.take().join();
                    future.complete(connection);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    future.completeExceptionally(e);
                }
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            future.completeExceptionally(e);
        }

        return future;
    }

    public static void releaseConnection(CompletableFuture<DatabaseConnection> connection) {
        if (pool == null) {
            initializePool();
        }

        try {
            pool.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error releasing connection to pool", e);
        }
    }

    public static class DatabaseConnection {
        private final Connection connection;

        public DatabaseConnection() {
            try {
                this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                System.out.println("Connected to the database");
            } catch (SQLException e) {
                throw new RuntimeException("Error creating database connection", e);
            }
        }

        public Connection getConnection() {
            return this.connection;
        }

        @Override
        public String toString() {
            return "DatabaseConnection{" +
                    "connection=" + connection +
                    '}';
        }
    }
}