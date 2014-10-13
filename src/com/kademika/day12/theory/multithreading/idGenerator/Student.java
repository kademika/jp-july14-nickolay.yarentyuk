package com.kademika.day12.theory.multithreading.idGenerator;

public class Student {

    private String name;
    private long id;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
