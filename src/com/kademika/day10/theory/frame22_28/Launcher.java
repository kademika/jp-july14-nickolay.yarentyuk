package com.kademika.day10.theory.frame22_28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Launcher {

    public static void main(String[] args) {

//        Something.printClassInfo(Phone.class);
//        System.out.println();
//
//        Something.printClassMethods(Phone.class);
//        System.out.println();
//
//        Something.printClassFields(Phone.class);
//
        Map map = new HashMap();
        map.put("width", 3);
        map.put("length", 4);
        map.put("height", 5);

//        System.out.println(Character.toLowerCase('A'));
//        System.out.println(Character.toTitleCase('a'));

        try {
            Box box = Something.initClass(Box.class, map);

            System.out.println(box.getWidth());
            System.out.println(box.getLength());
            System.out.println(box.getHeight());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

        List list = new ArrayList();
        list.add(6);
        list.add(8);
        list.add(7);

        try {
            Box box = Something.initClass(Box.class, list);

            System.out.println(box.getWidth());
            System.out.println(box.getLength());
            System.out.println(box.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

        map = new HashMap();
        map.put("width", 21);
        map.put("length", 22);
        map.put("height", 23);

        try {
            Box box = new Box();
            Something.setPrivates(box, map);

            System.out.println(box.getWidth());
            System.out.println(box.getLength());
            System.out.println(box.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
