package com.kademika.day13.theory.simpleThreadedServer;

import java.io.IOException;
import java.net.Socket;

public class NastyChump {

    public static void main(String[] args) {

        for (int i = 0; i < 30000; i++) {
            try {
                new Socket("localhost", 8080);
                System.out.println(i);
            } catch (IOException e) {
                System.out.println("Could not connect - " + e);
            }
        }
    }
}
