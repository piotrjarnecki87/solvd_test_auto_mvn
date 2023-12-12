package com.solvd.course.hm.project.it.company;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class ConnectionPool {
    private static BlockingQueue<CompletableFuture<DatabaseConnection>> pool;
    private static int poolSize = 5;
    private static Semaphore semaphore = new Semaphore(poolSize);

    private ConnectionPool() {
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
    }
}
