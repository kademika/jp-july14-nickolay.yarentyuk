package com.kademika.day12.theory.multithreading.threadDestroyer;

public class Demo {

    public static void main(String[] args) throws Exception {

        ThreadDestroyer threadDestroyer = new ThreadDestroyer();
        threadDestroyer.interrupt();

        System.out.println("Executing...");
        Thread.sleep(1000);

        threadDestroyer.destroyThread();
    }
}
