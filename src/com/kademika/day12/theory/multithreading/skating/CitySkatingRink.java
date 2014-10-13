package com.kademika.day12.theory.multithreading.skating;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CitySkatingRink implements SkatingRink {

    private Lock skatesLock;

    private List<Skates> skatesList;

    public CitySkatingRink() {
        skatesList = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            skatesList.add(new Skates());
        }

        skatesLock = new ReentrantLock();
    }

    @Override
    public Skates getSkates(Skater skater) {

        skatesLock.lock();

        Skates skates = skatesList.remove(0);

        skatesLock.unlock();

        System.out.println(skater.getName() + " got skates.");

        return skates;
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        skatesList.add(skates);

        System.out.println(skater.getName() + " returned skates.");
    }

    public boolean isSkatesListEmpty() {
        return skatesList.isEmpty();
    }
}
