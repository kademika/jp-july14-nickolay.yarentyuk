package com.kademika.day13.theory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();  //  blocking call never null
            try (
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
            ) {
                int data;
                while ((data = in.read()) != -1) {
                    data = transmogrify(data);
                    out.write(data);
                }
            }
        }
    }

    public static int transmogrify(int data) {
        if (Character.isLetter(data)) {
            return data ^ ' ';
        }
        return data;
    }
}
