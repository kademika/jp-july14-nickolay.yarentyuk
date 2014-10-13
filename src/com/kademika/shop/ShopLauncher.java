package com.kademika.shop;

import com.kademika.shop.devices.Device;
import com.kademika.shop.devices.Computer;
import com.kademika.shop.devices.Notebook;
import com.kademika.shop.devices.Printer;
import com.kademika.shop.devices.PrinterType;
import com.kademika.shop.devices.Telephone;
import com.kademika.shop.devices.TelephoneType;
import com.kademika.shop.devices.Tv;

import java.awt.*;

public class ShopLauncher {
	
	public static void main(String[] args) throws Exception {

//		SplashScreen splash = SplashScreen.getSplashScreen();
//        Thread.sleep(50);
//        splash.close();
//
//		Graphics2D g = splash.createGraphics();
//		g.setColor(Color.BLACK);
//		g.drawString("Loading...", 10, 20);
//		splash.update();
//		Thread.sleep(4000);
//
//		splash.close();
		
		Store store = new Store();
		
		addToStore1(store);
//		buy(store);
		
//		GuiTransaction tGui = new GuiTransaction(store);
//		GuiTransactionList lGui = new GuiTransactionList(store.getRegistration().getTransactions());
	}
	
	public static void addToStore1(Store store) {
		
		store.addDevice(new Computer("Smasung1", "AAA1", "Blue", false, false,
				"Intel Core i7", "nVidea", 1500, 8, 6, true, true, true, true, "Windows", 5000));
		store.addDevice(new Computer("Smasung2", "AAA2", "Blue", false, false,
				"Intel Core i7", "nVidea", 1500, 8, 6, true, true, true, true, "Linux", 3000));
		store.addDevice(new Computer("Smasung3", "AAA3", "Blue", false, false,
				"Intel Core i7", "nVidea", 1500, 8, 6, true, true, true, true, "Windows", 7000));
		
		store.addDevice(new Notebook("LG1", "BBB1", "Black", false, false,
				"Intel Core i3", "AMD", 500, 8, 4, true, true, true, true,
				3, 17, "Windows", 7000));
		store.addDevice(new Notebook("LG2", "BBB2", "Black", false, false,
				"Intel Core i3", "AMD", 500, 8, 4, true, true, true, true,
				3, 17, "Dos", 10000));
		store.addDevice(new Notebook("LG3", "BBB3", "Black", false, false,
				"Intel Core i3", "AMD", 500, 8, 4, true, true, true, true,
				3, 17, "Linux", 15000));
		
		store.addDevice(new Printer("Epson1", "T50", "Grey", false, false,
				PrinterType.STYLUS, true, 1000, 300));
		store.addDevice(new Printer("Epson2", "T50", "Grey", false, false,
				PrinterType.STYLUS, true, 100000001, 500));
		store.addDevice(new Printer("Epson3", "T50", "Grey", false, false,
				PrinterType.STYLUS, true, 100000001, 700));
		
		store.addDevice(new Telephone("Nokia1", "N8", "Steel", false, false,
				TelephoneType.SMARTPHONE, 1, "Symbian", 3000));
		store.addDevice(new Telephone("Nokia2", "N8", "Steel", false, false,
				TelephoneType.SMARTPHONE, 1, "Symbian", 4000));
		store.addDevice(new Telephone("Nokia3", "N8", "Steel", false, false,
				TelephoneType.SMARTPHONE, 1, "Symbian", 5000));
		
		store.addDevice(new Tv("Phillips1", "A1", "Grey", false, false,
				46, true, 5000));
		store.addDevice(new Tv("Phillips2", "A1", "Grey", false, false,
				46, true, 10000));
		store.addDevice(new Tv("Phillips3", "A1", "Grey", false, false,
				46, true, 15000));
	}
	
	public static void buy(Store store) {
		store.fullTotalDevices();
		System.out.println();
		
		Customer customer = new Customer("AAA", "AAA");
		Device[] devices = store.catalogByCategory(0);
		store.buy(customer, devices[0]);
		devices = store.catalogByCategory(2);
		store.buy(customer, devices[2]);
		
//		store.tranzactionList();
//		store.resultToday();
//		
//		store.nextDay(); // day 2
//		
//		store.results7Days();
//		
//		customer = new Customer("BBB", "BBB");
//		devices = store.catalogByCategory(4);
//		store.buy(customer, devices[1]);
//		
//		customer = new Customer("CCC", "CCC");
//		devices = store.catalogByCategory(1);
//		store.buy(customer, devices[2]);
//		
//		store.tranzactionList();
//		store.resultToday();
//		
//		store.nextDay(); // day 3
//		
//		customer = new Customer("DDD", "DDD");
//		devices = store.catalogByCategory(2);
//		store.buy(customer, devices[0]);
//		
//		store.resultToday();
//		
//		store.nextDay(); // day 4
//		
//		customer = new Customer("EEE", "EEE");
//		devices = store.catalogByCategory(0);
//		store.buy(customer, devices[0]);
//		
//		store.resultToday();
//		
//		store.nextDay(); // day 5
//		
//		customer = new Customer("FFF", "FFF");
//		devices = store.catalogByCategory(1);
//		store.buy(customer, devices[1]);
//		
//		store.resultToday();
//		
//		store.nextDay(); // day 6
//		
//		devices = store.catalogByCategory(4);
//		store.buy(customer, devices[1]);
//		
//		store.resultToday();
//		
//		store.nextDay(); // day 7
//		
//		customer = new Customer("GGG", "GGG");
//		devices = store.catalogByCategory(2);
//		store.buy(customer, devices[0]);
//		
//		devices = store.catalogByCategory(0);
//		store.buy(customer, devices[0]);
//		
//		store.resultToday();
//		
//		store.nextDay(); // day 8
//		
//		customer = new Customer("HHH", "HHH");
//		devices = store.catalogByCategory(0);
//		
//		devices = store.catalogByCategory(1);
//		store.buy(customer, devices[0]);
//		
//		store.resultToday();
//		
//		store.nextDay(); // day 9
//		
//		store.fullTotalDevices();
//		
//		store.results7Days();
	}
}
