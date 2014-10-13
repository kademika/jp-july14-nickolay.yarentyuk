package com.midgardabc.lesson_8Theory.frame_8_15_Shop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.midgardabc.lesson_5Homework.shop.Customer;
import com.midgardabc.lesson_5Homework.shop.Store;
import com.midgardabc.lesson_5Homework.shop.devices.Computer;
import com.midgardabc.lesson_5Homework.shop.devices.Device;
import com.midgardabc.lesson_5Homework.shop.devices.Notebook;
import com.midgardabc.lesson_5Homework.shop.devices.Printer;
import com.midgardabc.lesson_5Homework.shop.devices.Telephone;
import com.midgardabc.lesson_5Homework.shop.devices.Tv;

public class DeviceShopUI {

	private Store store;
	private int deviceIndex = 0;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	
	public DeviceShopUI(Store store) {
		this.store = store;
		
		JFrame f = new JFrame("Device shop");
		f.setLocation(300, 100);
		f.setMinimumSize(new Dimension(800, 600));
		
		f.getContentPane().add(createSellingPanel());
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	
	private JPanel createSellingPanel() {
		Computer[] computers = store.getComputers();
		Notebook[] notebooks = store.getNotebooks();
		Printer[] printers = store.getPrinters();
		Telephone[] phones = store.getPhones();
		Tv[] tvs = store.getTvs();
		
		Object[] devices = {store.getComputers(), store.getNotebooks(),
				store.getPrinters(), store.getPhones(),store.getTvs()};
		
		JPanel panel = new JPanel();	//	panel
		panel.setLayout(new GridBagLayout());	//	Layout
		
		JLabel lFirstName = new JLabel("First name:");	//	First name
//		panel.add(lFirstName);
		panel.add(lFirstName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		panel.add(tfFirstName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JLabel lLastName = new JLabel("Last name:");	//	Last name
		panel.add(lLastName, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(5, 0, 0, 0), 0, 0));
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		panel.add(tfLastName, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		ButtonGroup deviceGroup = new ButtonGroup();	//	panel with radiobuttons
		JLabel lDevices = new JLabel("Devices:");
		JPanel pDevices = new JPanel();
		pDevices.setLayout(new GridLayout(5, 1));
		pDevices.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		ActionListener rbListener = new RBListener();
		
		int count = 0;
		for (int i = 0; i < computers.length; i++) {
			if (computers[i] == null) {
				break;
			}
			count ++;
		}
		for (int i = 0; i < count; i++) {
			Computer c = computers[i];
			
			JRadioButton rb = new JRadioButton(c.getProduser() + " " + c.getModel());
			
			rb.setActionCommand(String.valueOf(i));
			rb.addActionListener(rbListener);
			if (i == 0) {
				rb.setSelected(true);
			}
			
			deviceGroup.add(rb);
			pDevices.add(rb);
		}
		
		panel.add(lDevices, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 20, 0, 0), 0, 0));
		panel.add(pDevices, new GridBagConstraints(1, 1, 1, computers.length, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 20, 0, 0), 0, 0));
		
		JLabel lCount = new JLabel("Count:");	//	Count
		panel.add(lCount, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 20, 0, 0), 0, 0));
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		JFormattedTextField ftfCount = new JFormattedTextField(nf);
		ftfCount.setColumns(3);
		ftfCount.setValue(1);
		panel.add(ftfCount, new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 20, 0, 0), 0, 0));
		
		JButton btnBuy = new JButton("Buy"); // btnBuy
		panel.add(btnBuy, new GridBagConstraints(3, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 20, 0, 0), 40, 0));
		
		btnBuy.addActionListener(new ActionListener() {	// btnBuy click
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Customer c = new Customer(tfFirstName.getText(), tfLastName.getText());
				
				Computer dev = store.getComputers()[deviceIndex];
				
				store.buy(c, dev);
				
				tfFirstName.setText("");
				tfLastName.setText("");
			}
		});
		
		return panel;
	}
	
	private class RBListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			deviceIndex = Integer.parseInt(e.getActionCommand());
		}
	}
}
