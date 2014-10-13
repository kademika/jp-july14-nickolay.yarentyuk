package com.kademika.day12.theory.multithreading.skating;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NiceWinterDay4ExecutorServiceDemo {

    public static void main(String[] args) {

        System.out.println("Good morning everyone we are opened!!!");

        final SkatingRink skatingRink = new SchoolSkatingRink();

        final Random random = new Random();

        final ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 10; i++) {
                final Skater skater = new Skater("Skater " + i);

                Callable<Integer> callable = new Callable<Integer>() {

                    @Override
                    public Integer call() throws Exception {
                        Skates skates = skatingRink.getSkates(skater);
                        sleep(random.nextInt(2000));
                        skatingRink.returnSkates(skates, skater);

                        return null;
                    }
                };

                executorService.submit(callable);
            }

        } finally {
            executorService.shutdown();
        }

        System.out.println("We are closed.");
    }

    private static void sleep(int timeout) {
        try {
            Thread.currentThread().sleep(timeout);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
