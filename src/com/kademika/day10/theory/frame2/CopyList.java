package com.kademika.day10.theory.frame2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CopyList {

    public static void main(String[] args) {

        List<Device> list1 = new ArrayList<>();
        List<Device> list2 = new ArrayList<>();

        Phone phone1 = new Phone(2L, "Samsung", "x1", Color.YELLOW, 100, 1, "Android");
        list1.add(phone1);
        Tv tv1 = new Tv(3, "Phillips", "x1", Color.YELLOW, 100, 46, true);
        list1.add(tv1);
        Phone phone2 = new Phone(1L, "Nokia", "x1", Color.YELLOW, 100, 1, "Android");
        list1.add(phone2);

        for (Device device : list1) {
            System.out.println(device.toString());
        }
        System.out.println();

        Tv tv2 = new Tv(4, "Sony", "x1", Color.YELLOW, 100, 46, true);
        list2.add(tv2);

        for (Device device : list2) {
            System.out.println(device.toString());
        }
        System.out.println();

        copy(list1, list2);

        for (Device device : list1) {
            System.out.println(device.toString());
        }
        System.out.println();

        for (Device device : list2) {
            System.out.println(device.toString());
        }
    }

    public static void copy(List<? extends Device> source, List<? super Device> copyTo) {
        for (Device device : source) {
            copyTo.add(device);
        }
    }
}
