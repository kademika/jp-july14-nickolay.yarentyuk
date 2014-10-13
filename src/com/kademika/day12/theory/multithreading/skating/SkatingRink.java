package com.kademika.day12.theory.multithreading.skating;

public interface SkatingRink {

    public Skates getSkates(Skater skater);

    public void returnSkates(Skates skates, Skater skater);
}
