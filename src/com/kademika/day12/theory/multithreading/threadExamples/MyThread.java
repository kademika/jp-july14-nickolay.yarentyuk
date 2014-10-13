package com.kademika.day12.theory.multithreading.threadExamples;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Running " + Thread.currentThread().getName() + " " + this.getClass().getSimpleName());
    }
}
