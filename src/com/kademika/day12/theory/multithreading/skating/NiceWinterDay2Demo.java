package com.kademika.day12.theory.multithreading.skating;

import java.util.Random;

public class NiceWinterDay2Demo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Good morning everyone we are opened!!!");

        final SkatingRink skatingRink = new VipSkatingRinkQueued();

        final Random random = new Random();

        for (int i = 0; i < 10; i++) {
            final Skater skater = new Skater("Skater " + i);

            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    Skates skates = null;
                    while (skates == null) {
                        skates = skatingRink.getSkates(skater);
                        sleep(random.nextInt(2000));
                    }

                    skatingRink.returnSkates(skates, skater);
                }
            });

            thread.start();

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
