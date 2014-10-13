package com.kademika.day10.theory;

public class Frame21Launcher {

    public static void main(String[] args) {

//        System.out.println(Byte.class.getName());
//        System.out.println(Short.class.getName());
//        System.out.println(Integer.class.getName());
//        System.out.println(Long.class.getName());
//        System.out.println();
//
//        System.out.println(Float.class.getName());
//        System.out.println(Double.class.getName());

//        System.out.println(Number.class.getClasses());

        Class[] classes = Number.class.getDeclaredClasses();

        for (Class c : classes) {
            System.out.println(c.getSimpleName());
        }
    }
}
