package com.kademika.day12.theory.multithreading.idGenerator;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Demo {

    public static void main(String[] args) {

        final IdGenerator idGenerator = new IdGenerator();
        final Random random = new Random();
        final CountDownLatch countDownLatch = new CountDownLatch(1000);

        for (int i = 0; i < 1000; i++) {

            final Student student = new Student("Student " + i);

            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        countDownLatch.await();
//                        Thread.sleep(random.nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    student.setId(idGenerator.getNextId());
                    System.out.println(student.getName() + ", id: " + student.getId());
                }
            });
            thread.start();
            countDownLatch.countDown();
        }
    }
}
