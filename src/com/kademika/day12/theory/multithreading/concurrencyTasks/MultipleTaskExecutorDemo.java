package com.kademika.day12.theory.multithreading.concurrencyTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleTaskExecutorDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>();

        List<Integer> results = new ArrayList<>();
        try {
            for (int i = 0; i < 10; i++) {
                futures.add(executorService.submit(new Task()));
            }

            for (Future<Integer> future : futures) {
                results.add(future.get());
            }

        } finally {
            executorService.shutdown();
        }

        for (Integer i : results) {
            System.out.println(i);
        }
    }
}
