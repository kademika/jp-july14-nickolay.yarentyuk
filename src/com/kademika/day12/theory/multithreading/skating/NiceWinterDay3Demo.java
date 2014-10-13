package com.kademika.day12.theory.multithreading.skating;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class NiceWinterDay3Demo {

    public static void main(String[] args) {

        System.out.println("Good morning everyone we are opened!!!");

        final SkatingRink skatingRink = new SchoolSkatingRink();

        final Random random = new Random();

        final CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 10; i++) {
            final Skater skater = new Skater("Skater " + i);

            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    Skates skates = skatingRink.getSkates(skater);
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        // ignore
                    }
                    System.out.println(skater.getName() + " on ice.");
                    sleep(random.nextInt(2000));
                    skatingRink.returnSkates(skates, skater);
                }
            });

            thread.start();
            countDownLatch.countDown();

            sleep(random.nextInt(1000));
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
