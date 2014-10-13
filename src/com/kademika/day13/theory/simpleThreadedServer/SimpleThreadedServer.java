package com.kademika.day13.theory.simpleThreadedServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleThreadedServer {

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            final Socket socket = serverSocket.accept();    //  blocking call never null

            new Thread(new Runnable() {

                @Override
                public void run() {
                    Utils.process(socket);
                }
            }).start();
        }
    }
}
