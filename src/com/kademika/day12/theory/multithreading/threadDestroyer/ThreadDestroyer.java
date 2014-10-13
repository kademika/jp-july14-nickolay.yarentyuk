package com.kademika.day12.theory.multithreading.threadDestroyer;

public class ThreadDestroyer extends Thread {

    private volatile boolean destroyed = false;

    public void destroyThread() {
        destroyed = true;
    }

    @Override
    public void run() {
        while (!destroyed) {
            try {
                System.out.println("Thread is executing.");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println("Thread is destroyed.");
    }
}
