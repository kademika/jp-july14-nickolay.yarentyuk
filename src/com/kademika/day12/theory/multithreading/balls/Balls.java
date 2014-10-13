package com.kademika.day12.theory.multithreading.balls;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Balls extends JPanel {

    public static void main(String[] args) {

        new Balls();
    }

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private static final Color[] COLORS = new Color[] {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            new Color(30, 144, 255),
            Color.BLUE,
            new Color(123, 104, 238),
            Color.WHITE,
            Color.BLACK
    };

    private List <Ball> balls;

    public Balls() {
        JFrame frame = new JFrame("Balls");
        frame.setLocation(450, 150);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        this.setBackground(Color.WHITE);
        frame.pack();
        frame.setVisible(true);

        createBalls();
        action();
    }

    private void createBalls() {
        balls = new ArrayList<>();
        balls.add(new Ball(WIDTH, 30, COLORS[0], 100 / 60));
        balls.add(new Ball(WIDTH, 60, COLORS[1], 200 / 60));
        balls.add(new Ball(WIDTH, 90, COLORS[2], 300 / 60));
        balls.add(new Ball(WIDTH, 120, COLORS[3], 400 / 60));
        balls.add(new Ball(WIDTH, 150, COLORS[4], 500 / 60));
        balls.add(new Ball(WIDTH, 180, COLORS[5], 600 / 60));
        balls.add(new Ball(WIDTH, 210, COLORS[6], 700 / 60));
        balls.add(new Ball(WIDTH, 240, COLORS[0], 800 / 60));
        balls.add(new Ball(WIDTH, 270, COLORS[1], 900 / 60));
        balls.add(new Ball(WIDTH, 300, COLORS[2], 1000 / 60));

        for (Ball ball : balls) {
            ball.start();
        }

//        repaint();
    }

    private void action() {
        try {
            while (true) {
                Thread.sleep(1000 / 60);
                repaint();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Ball ball : balls) {
            g.setColor(ball.getColor());
            g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
        }
    }
}
