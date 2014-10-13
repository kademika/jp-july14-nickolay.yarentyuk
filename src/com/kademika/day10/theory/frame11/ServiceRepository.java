package com.kademika.day10.theory.frame11;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {

    List<Service> list = new ArrayList<>();

    public void add(Service item) {
        list.add(item);
    }

    public boolean isExists(Service item) {
        for (Service s : list) {
            if (s == item) {
                return true;
            }
        }
        return false;
    }

    public Service get(int index) {
        return list.get(index);
    }

    public List<Service> getAll() {
        return new ArrayList<>(list);
    }

    public void delete(Service item) {
        list.remove(item);
    }
}
