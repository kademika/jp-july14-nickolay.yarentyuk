package com.kademika.day10.theory.frame22_28;

import com.kademika.day10.theory.frame2.Phone;
import com.kademika.day10.theory.frame2.Tv;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Frame27ApplicationManagerDemoLauncher {

    public static void main(String[] args) {

        ApplicationManager applicationManager = new ApplicationManager();

//        Tv tv = new Tv(1, "Phillips", "111", Color.YELLOW, 15000, 42, true);
//        Phone phone = new Phone(2, "Samsung", "N8", Color.GRAY, 1500, 1, "Android");

        System.out.println(applicationManager.addClass(Tv.class));
        System.out.println(applicationManager.addClass(Phone.class));

        List list = new ArrayList();
        list.add(1);
        list.add("Samsung");
        list.add("N8");
        list.add(Color.GRAY);
        list.add(1500);
        list.add(1);
        list.add("Android");
        System.out.println(applicationManager.addClass(Phone.class, list));
    }
}
