package com.kademika.day12.theory.multithreading.concurrencyTasks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleTaskExecutorDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> future = executorService.submit(new Task());

            System.out.println(future.get());
        } finally {
            executorService.shutdown();
        }
    }
}
