package com.kademika.shopGeneric;

import javafx.scene.control.TableColumn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GuiTransactionJournal {

    private JTable table;
    private JMenuBar menuBar;
    private JPanel panel;

    List<Transaction> transactions;
    Object[][] data;

    public GuiTransactionJournal(List<Transaction> transactions) {

        this.transactions = transactions;

        JFrame frame = new JFrame("Device shop");

        frame.setLocation(600, 100);
        frame.setMinimumSize(new Dimension(800, 600));

        frame.getRootPane().setJMenuBar(setMenuBar());
        frame.getContentPane().add(setPanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JMenuBar setMenuBar() {
        JMenuItem menuItem = new JMenuItem("Buy device");
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy device.");
            }
        });

        JMenu menu = new JMenu("File");
        menu.add(menuItem);

        JMenuBar menuBar1 = new JMenuBar();
        menuBar1.add(menu);

        return menuBar1;
    }

    private JPanel setPanel() {
        JPanel panel1 = new JPanel();

        String[] names = {"No", "Customer", "Device", "Price"};
        data = new String[100][4];
        table = new JTable(data, names);

        JScrollPane scrollPane = new JScrollPane(table);
        panel1.add(scrollPane);

        return panel1;
    }

    public void refreshData() {
        for (Transaction transaction : transactions) {
            data[transaction.getNumber() - 1][0] = transaction.getNumber();
            data[transaction.getNumber() - 1][1] = transaction.getDate().toString();
            data[transaction.getNumber() - 1][2] = transaction.getCustomer().toString();
            data[transaction.getNumber() - 1][3] = transaction.getDevice().shortFeatures();
        }

        table.getColumn(0).getCellEditor();

        table.repaint();
        panel.repaint();
    }
}
