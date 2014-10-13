package com.kademika.day10.theory.frame2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Store<T extends Device> {

    private List<T> list = new ArrayList();

    public void add(T data) {
        list.add(data);
    }

    public T get(int index) {
        return list.get(index);
    }

    public List<T> getAll() {
        return new ArrayList<>(list);
    }

    public void delete(T data) {
        list.remove(data);
    }

    public void sortById() {
        Collections.sort(list, new Comparator<T>() {

            @Override
            public int compare(T obj1, T obj2) {
                long id1 = obj1.getId();
                long id2 = obj2.getId();

                if (id1 > id2) {
                    return 1;
                } else if (id1 < id2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void sortByProducer() {
        Collections.sort(list, new Comparator<T>() {

            @Override
            public int compare(T obj1, T obj2) {
                String producer1 = obj1.getProducer();
                String producer2 = obj2.getProducer();

                return producer1.compareTo(producer2);
            }
        });
    }
}
