package com.kademika.day10.homework;

import com.kademika.day10.theory.frame2.Phone;
import com.kademika.day10.theory.frame2.Tv;
import com.kademika.day10.theory.frame22_28.Something;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hwFrame4_5InitClassDemo {

    public static void main(String[] args) throws Exception {

        // Homework: Frame 4: task
        List list = new ArrayList();

        Phone phone1 = Something.initClass(Phone.class, list);
        System.out.println(phone1.toString());

        list.clear();
        list.add(1L);
        list.add("Samsung");
        list.add("N8");
        list.add(Color.GRAY);
        list.add(1500.0);
        list.add(1);
        list.add("Android");
        Phone phone2 = Something.initClass(Phone.class, list);
        System.out.println(phone2.toString());

        list.clear();
        Tv tv1 = Something.initClass(Tv.class, list);
        System.out.println(tv1.toString());

        list.clear();
        list.add(2L);
        list.add("Phillips");
        list.add("x1");
        list.add(Color.YELLOW);
        list.add(100.0);
        list.add(46);
        list.add(true);
        Tv tv2 = Something.initClass(Tv.class, list);
        System.out.println(tv2.toString());
        System.out.println();

        // Homework: Frame 5: task
        Map<String, Object> map = new HashMap<>();

        map.put("producer", "Nokia");   //  !
        map.put("price", 500);  //  !
        map.put("totalSim", 2);
        map.put("os", "Symbian");
        Something.setPrivates(phone2, map);
        System.out.println(phone2.toString());
    }
}
