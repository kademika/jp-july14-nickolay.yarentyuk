package com.kademika.day10.theory.frame2;

        import java.awt.*;
        import java.util.*;
        import java.util.List;
        import java.util.ArrayList;

public class LauncherFrame4 {

    public static void main(String[] args) {

//        Store<Device> s1 = new Store<>();
//        Store<Phone> s2 = new Store<>();
//        Store<Tv> s3 = new Store<>();

        Store<Device> store = new Store();

        Phone phone1 = new Phone(2L, "Samsung", "x1", Color.YELLOW, 100, 1, "Android");
        store.add(phone1);

        Tv tv1 = new Tv(3, "Phillips", "x1", Color.YELLOW, 100, 46, true);
        store.add(tv1);

        Phone phone2 = new Phone(1L, "Nokia", "x1", Color.YELLOW, 100, 1, "Android");
        store.add(phone2);

        store.sortByProducer();
        List<Device> list = store.getAll();
        for (Device device : list) {
            System.out.println(device.toString());
        }

        System.out.println();

        store.sortById();
        list = store.getAll();
        for (Device device : list) {
            System.out.println(device.toString());
        }
    }
}
