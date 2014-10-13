package com.kademika.day12.theory.multithreading.skating;

public class SchoolSkatingRink implements SkatingRink {

    @Override
    public Skates getSkates(Skater skater) {
        System.out.println(skater.getName() + " got skates.");
        return new Skates();
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        System.out.println(skater.getName() + " returned skates.");
    }
}
