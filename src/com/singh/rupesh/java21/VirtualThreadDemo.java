package com.singh.rupesh.java21;

import java.time.Duration;
import java.util.ArrayList;

// when we use virtual threads - os or platform thread is released automatically during IO operations making such tasks non blocking
// for windows: When running million threads with Virtual threads, you may have to increase maximum heap size to 3G with -Xmx3G
public class VirtualThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting main");
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            threads.add(startThread());
        }

        Thread.sleep(Duration.ofMinutes(5));
        //Virtual threads are daemon threads in nature ie.. program closes without waiting for these threads to complete
        //We can use join on each of them to ensure that main thread waits for them to complete.
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Ending main");
    }

    private static Thread startThread() {
        //new Thread(() -> handleUserRequest()).start();
        return Thread.startVirtualThread(VirtualThreadDemo::handleUserRequest);
    }

    private static void handleUserRequest() {
        //System.out.println("Starting thread " + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // System.out.println("Ending thread " + Thread.currentThread());
    }
}
