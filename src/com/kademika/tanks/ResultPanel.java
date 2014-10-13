package com.kademika.tanks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel {

    private JLabel labelGameOver;
    private JLabel labelMessage;
    private JLabel labelQuestion;
    private JButton buttonYes;
    private JButton buttonNo;

    private MainFrame frame;
    private String message;

    public ResultPanel(MainFrame frame/*, String message*/) {

        this.frame = frame;
        this.message = message;

        setComponents();
    }

    public void setMessage(boolean defenderWon) {
        if (defenderWon) {
            labelMessage.setText("Defender won.");
        } else {
            labelMessage.setText("Aggressor won.");
        }
    }

    private void setComponents() {
        setLayout(new GridBagLayout());

        labelGameOver = new JLabel("Game over.");
        add(labelGameOver, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 10, 10));

        labelMessage = new JLabel(/*message*/);
        add(labelMessage, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 10, 10));

        labelQuestion = new JLabel("Do you wont to start new game?");
        add(labelQuestion, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 10, 0), 10, 10));

        buttonYes = new JButton("Yes");
        add(buttonYes, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

        buttonNo = new JButton("No");
        add(buttonNo, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

        buttonYes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.loadSetupPanel();
            }
        });

        buttonNo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
