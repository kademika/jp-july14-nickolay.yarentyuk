package com.kademika.day10.homework;

import com.kademika.day10.theory.frame2.Device;
import com.kademika.day10.theory.frame2.Phone;
import com.kademika.day10.theory.frame2.Tv;
import com.kademika.day10.theory.frame22_28.ApplicationManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class hwFrame1Demo {

    public static void main(String[] args) {

        List<Device> devices = new ArrayList<>();
        List<Phone> phones = new ArrayList<>();
        List<Tv> tvs = new ArrayList<>();

        Phone phone1 = new Phone(1L, "Samsung", "N8", Color.GRAY, 1500.0, 1, "Android");
        devices.add(phone1);
        Tv tv1 = new Tv(1L, "Phillips", "x1", Color.YELLOW, 100.0, 46, true);
        devices.add(tv1);

        Phone phone2 = new Phone(2L, "Samsung", "N8", Color.GRAY, 1500.0, 1, "Android");
        devices.add(phone2);
        Phone phone3 = new Phone(3L, "Samsung", "N8", Color.GRAY, 1500.0, 1, "Android");
        devices.add(phone3);

        Tv tv2 = new Tv(2L, "Phillips", "x1", Color.YELLOW, 100.0, 46, true);
        devices.add(tv2);
        Tv tv3 = new Tv(3L, "Phillips", "x1", Color.YELLOW, 100.0, 46, true);
        devices.add(tv3);

        ApplicationManager.copy(phones, devices);
        ApplicationManager.copy(tvs, devices);

        for (Device device : devices) {
            System.out.println(device.toString());
        }

//        ApplicationManager.copy(phones, tvs);   //  error
//        ApplicationManager.copy(tvs, phones);   //  error
//        ApplicationManager.copy(devices, phones);   //  error
//        ApplicationManager.copy(devices, tvs);   //  error
    }
}
