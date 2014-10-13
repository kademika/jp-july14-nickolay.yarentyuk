package com.kademika.day12.theory.multithreading.threadExamples;

public class Demo {

    public static void main(String[] args) {

        System.out.println("Running " + Thread.currentThread().getName());

        new MyThread().run();   //  wrong

        new MyThread().start();

        new Thread(new MyRunnable()).start();
    }
}
