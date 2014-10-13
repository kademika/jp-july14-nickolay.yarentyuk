package com.kademika.day12.theory.multithreading.drawBridge;

import javax.swing.*;
import java.awt.*;

public class DrawBridge extends JPanel {

    public static void main(String[] args) {
        new DrawBridge();
    }

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private int speedGame = 1000 / 60;
    private int speedBridge = 1000 / 50;
    private int speedCar = 1000 / 60;

    private Road road;
    private River river;
    private Bridge bridge;
    private Car car;

    public DrawBridge() {
        JFrame frame = new JFrame("DrawBridge");
        frame.setLocation(450, 150);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        road = new Road(0, 200, 250, 10, 300, 200, 100, 10, Color.GRAY);
        river = new River(240, 210, 70, 30, Color.BLUE);
        bridge = new Bridge(250, 150, 200, 50, 10, Color.GREEN);
        car = new Car(0, 180, 30, 20, Color.RED);

        moveBridge();

        moveCar();

        while (true) {
            repaint();
            sleep(speedGame);
        }
    }

    private void moveBridge() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        synchronized (bridge) {
                            bridge.wait();
                        }
                        while (!bridge.isOpen()) {
                            bridge.addY();
                            sleep(speedBridge);
                        }
                        synchronized (car) {
                            car.notify();
                        }
                        synchronized (bridge) {
                            bridge.wait();
                        }
                        while (!bridge.isClosed()) {
                            bridge.subY();
                            sleep(speedBridge);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void moveCar() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                        while (car.getX() + car.getWidth() + 15 < WIDTH) {
                            if (!bridge.isZone(car.getX(), car.getX() + car.getWidth())) {
                                if (bridge.isOpen()) {
                                    synchronized (bridge) {
                                        bridge.notify();
                                    }
                                }
                                car.addX();
                                sleep(speedCar);
                            } else {
                                if (!bridge.isOpen()) {
                                    synchronized (bridge) {
                                        bridge.notify();
                                    }
                                    synchronized (car) {
                                        car.wait();
                                    }
                                } else {
                                    car.addX();
                                    sleep(speedCar);
                                }
                            }
                        }

                        car = new Car(0, 180, 30, 20, Color.RED);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(road.getColor());    //  road
        g.fillRect(road.getLeftX(), road.getLeftY(), road.getLeftWidth(), road.getLeftHeight());
        g.fillRect(road.getRightX(), road.getRightY(), road.getRightWidth(), road.getRightHeight());

        g.setColor(river.getColor());    //  river
        g.fillRect(river.getX(), river.getY(), river.getWidth(), river.getDepth());

        g.setColor(bridge.getColor());  //  bridge
        g.fillRect(bridge.getX(), bridge.getY(), bridge.getWidth(), bridge.getHeight());

        g.setColor(car.getColor()); //  car
        g.fillRect(car.getX(), car.getY(), car.getWidth(), car.getHeight());
    }

    private void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
