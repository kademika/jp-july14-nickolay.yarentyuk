package com.kademika.day12.theory.multithreading.idGenerator;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private AtomicLong id;

    public IdGenerator() {
        id = new AtomicLong(0);
    }

    public long getNextId() {
        return id.addAndGet(1);
    }
}
