package com.kademika.day12.theory.multithreading.skating;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class VipSkatingRinkQueued implements SkatingRink {

    private final Queue<Skates> skatesShelf = new LinkedBlockingQueue<>();

    public VipSkatingRinkQueued() {

        for (int i = 0; i < 3; i++) {
            skatesShelf.add(new Skates());
        }
    }

    @Override
    public Skates getSkates(Skater skater) {

        Skates skates = skatesShelf.poll();

        if (skates != null) {
            System.out.println(skater.getName() + " got skates.");
        }

        return skates;
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        skatesShelf.add(skates);

        System.out.println(skater.getName() + " returned skates.");
    }
}
