package com.kademika.day10.homework;

import com.kademika.day10.theory.frame2.Phone;
import com.kademika.day10.theory.frame22_28.ApplicationManager;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class hwFrame2getServiceDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        ApplicationManager<Phone> applicationManager = new ApplicationManager();

        List list = new ArrayList();
        list.add(1L);
        list.add("Samsung");
        list.add("N8");
        list.add(Color.GRAY);
        list.add(1500.0);
        list.add(1);
        list.add("Android");

        Phone phone = applicationManager.getSevice(Phone.class, list);

        if (phone == null) {
            System.out.println("Object is empty.");
        } else {
            System.out.println(phone.toString());
        }
    }
}
