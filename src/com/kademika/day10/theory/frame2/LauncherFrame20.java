package com.kademika.day10.theory.frame2;

public class LauncherFrame20 {

    public static void main(String[] args) {
        System.out.println(Phone.class.getName());

        Tv tv = new Tv();
        System.out.println(tv.getClass().getSimpleName());
    }
}
