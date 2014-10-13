package com.kademika.shop;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiTransactionList {

    private JTable table;
    private JMenuBar menu;

    private Registration registration;
    private Transaction[] transactions;
    private static int tCounter = 0;
    private Object[][] data;

    public GuiTransactionList(final Store store) {
        // TODO Auto-generated constructor stub
        this.registration = store.getRegistration();
//        this.transactions = store.getRegistration().getTransactions();

        JFrame f = new JFrame("Transaction list");
        f.setLocation(600, 100);
        f.setMinimumSize(new Dimension(800, 600));

        JMenuItem mi = new JMenuItem("Buy device");
        mi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                new GuiTransaction(store);
            }
        });

        JMenu m = new JMenu("File");
        m.add(mi);

        JMenuBar mb = new JMenuBar();
        mb.add(m);

        f.getRootPane().setJMenuBar(mb);

        f.getContentPane().add(createListPanel());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public JPanel createListPanel() {
        JPanel panel = new JPanel();

        String[] names = {"No", "Customer name", "Device"};

        data = new String[100][3];
//        data[1][1] = "X";
//        for (tCounter = 0; tCounter < transactions.length; tCounter++) {
//            if (transactions[tCounter] == null) {
//                break;
//            }
//            data[tCounter][0] = String.valueOf(transactions[tCounter].getNumber());
//            data[tCounter][1] = transactions[tCounter].getCustomer();
//            data[tCounter][2] = transactions[tCounter].getDevice();
//        }

        table = new JTable(data, names);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);

        JScrollPane sp = new JScrollPane(table);

        panel.add(sp);
//
//        data = new String[3][3];
//        data[1][1] = "X";
//        table = new JTable(data, names);
//        table.repaint();
//
//        panel.repaint();

        return panel;
    }

    public void addTransaction(Transaction t) {
        data[tCounter][0] = String.valueOf(t.getNumber() + 1);
        data[tCounter][1] = t.getCustomer();
        data[tCounter][2] = t.getDevice();

        tCounter++;
    }
}
