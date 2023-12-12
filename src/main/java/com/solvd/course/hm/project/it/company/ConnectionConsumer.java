package com.solvd.course.hm.project.it.company;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class ConnectionConsumer implements Runnable {
    private final CountDownLatch connectionsAvailable;
    public ConnectionConsumer(CountDownLatch connectionsAvailable) {
        this.connectionsAvailable = connectionsAvailable;
    }
    @Override
    public void run() {
        CompletableFuture<ConnectionPool.DatabaseConnection> connection = ConnectionPool.getConnectionAsync();

        ConnectionPool.releaseConnection(connection);

        connectionsAvailable.countDown();
    }
}
