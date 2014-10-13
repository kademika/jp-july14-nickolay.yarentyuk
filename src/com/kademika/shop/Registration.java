package com.kademika.shop;

import com.kademika.shop.devices.Device;

public class Registration {

	private Transaction[] transactions;
	private Result result;
	private Result[] results7Days;

	private int deviceCounter; 

	public Registration() {

		transactions = new Transaction[100];
		result = new Result();
		results7Days = new Result[7];
		
		deviceCounter = 0;
	}

	public void newTransaction(Customer customer, Device device, GuiTransactionList lGui) {

		if ((transactions.length - 10) < deviceCounter) {
			Transaction[] t = transactions;
			transactions = new Transaction[t.length + 100];
			System.arraycopy(t, 0, transactions, 0, t.length);
		} else {
			Transaction t = new Transaction(deviceCounter, customer, device);
            transactions[deviceCounter++] = t;
			lGui.addTransaction(t);
		}
		result.addTotal(1);
		result.addCost(device.getPrice());
	}

	public void transactionList() {

		System.out.println();
		if (transactions[0] == null) {
			System.out.println("List is empty");
		}
		else {
			System.out.println("Transaction today:");
			System.out.println();

			for (int i = 0; i < transactions.length; i++) {
				if (transactions[i] == null) {
					break;
				}
				System.out.println(transactions[i].getNumber() + ". "
						+ transactions[i].getCustomer() + " "
						+ transactions[i].getDevice() + " "
						+ transactions[i].getPrice() + " grn.");
			}
		}
	}

	public void resultToday() {

		System.out.println();
		System.out.println("Result of transaction today:");
		System.out.println();

		System.out.println("Devices: " + result.getTotal() + ": "
				+ result.getCost() + " grn.");
	}

	public void results7Days() {

		System.out.println();
		System.out.println("Transactions for 7 days:");
		System.out.println();

		for (int i = 6; i >= 0; i--) {
			if (results7Days[i] == null) {
				break;
			}
			System.out.println(7 - i + ". " + results7Days[i].getTotal() + ": "
					+ results7Days[i].getCost() + " grn.");
		}
	}

	public void nextDay() {

		for (int i = 6; i > 0; i--) {
			results7Days[i] = results7Days[i - 1];
		}
		results7Days[0] = result;

		result = new Result();
		transactions = new Transaction[100];
		deviceCounter = 0;
		
		System.out.println();
		System.out.println("Next day:");
		System.out.println();
	}

	public Transaction[] getTransactions() {
		return transactions;
	}

    public int getDeviceCounter() {
        return deviceCounter;
    }
}
