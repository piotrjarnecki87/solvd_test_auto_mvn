package com.solvd.course.hm.project.it.company;


import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(7);

        ConnectionPool.initializePool();
        CountDownLatch connectionsAvailable = new CountDownLatch(5);

        try {
            for (int i = 0; i < 5; i++) {
                threadPool.execute(new ConnectionConsumer(connectionsAvailable));
            }

            for (int i = 0; i < 2; i++) {
                threadPool.execute(new ConnectionConsumer(connectionsAvailable));
            }

            connectionsAvailable.await();

            OrganizationProcessor01 organizationProcessor01 = new OrganizationProcessor01();
            Thread organizationProcessor02 = new Thread(new OrganizationProcessor02());

            organizationProcessor01.start();
            organizationProcessor02.start();

            organizationProcessor01.join();
            organizationProcessor02.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}


