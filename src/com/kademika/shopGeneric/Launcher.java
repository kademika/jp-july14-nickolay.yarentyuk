package com.kademika.shopGeneric;

import com.kademika.shopGeneric.devices.*;

public class Launcher {

    private Device device1;
    private Device device2;

    public static void main(String[] args) {

        Store store = new Store();

        Launcher launcher = new Launcher();

        launcher.addToStore1(store);
        launcher.buy(store);
    }

    public void addToStore1(Store store) {
        device1 = new Computer("Smasung1", "AAA1", "Blue", false, false,
                "Intel Core i7", "nVidea", 1500, 8, 6, true, true, true, true, "Windows", 5000);
        device2 = new Computer("Smasung2", "AAA2", "Blue", false, false,
                "Intel Core i7", "nVidea", 1500, 8, 6, true, true, true, true, "Linux", 3000);

//        store.addDevice(device1);
//        store.addDevice(device2);
//        store.addDevice(new Computer("Smasung3", "AAA3", "Blue", false, false,
//                "Intel Core i7", "nVidea", 1500, 8, 6, true, true, true, true, "Windows", 7000));
//
//        store.addDevice(new Notebook("LG1", "BBB1", "Black", false, false,
//                "Intel Core i3", "AMD", 500, 8, 4, true, true, true, true,
//                3, 17, "Windows", 7000));
//        store.addDevice(new Notebook("LG2", "BBB2", "Black", false, false,
//                "Intel Core i3", "AMD", 500, 8, 4, true, true, true, true,
//                3, 17, "Dos", 10000));
//        store.addDevice(new Notebook("LG3", "BBB3", "Black", false, false,
//                "Intel Core i3", "AMD", 500, 8, 4, true, true, true, true,
//                3, 17, "Linux", 15000));
//
//        store.addDevice(new Printer("Epson1", "T50", "Grey", false, false,
//                PrinterType.STYLUS, true, 1000, 300));
//        store.addDevice(new Printer("Epson2", "T50", "Grey", false, false,
//                PrinterType.STYLUS, true, 100000001, 500));
//        store.addDevice(new Printer("Epson3", "T50", "Grey", false, false,
//                PrinterType.STYLUS, true, 100000001, 700));
//
//        store.addDevice(new Phone("Nokia1", "N8", "Steel", false, false,
//                TelephoneType.SMARTPHONE, 1, "Symbian", 3000));
//        store.addDevice(new Phone("Nokia2", "N8", "Steel", false, false,
//                TelephoneType.SMARTPHONE, 1, "Symbian", 4000));
//        store.addDevice(new Phone("Nokia3", "N8", "Steel", false, false,
//                TelephoneType.SMARTPHONE, 1, "Symbian", 5000));
//
//        store.addDevice(new Tv("Phillips1", "A1", "Grey", false, false,
//                46, true, 5000));
//        store.addDevice(new Tv("Phillips2", "A1", "Grey", false, false,
//                46, true, 10000));
//        store.addDevice(new Tv("Phillips3", "A1", "Grey", false, false,
//                46, true, 15000));
    }

    public void buy(Store store) {
        Customer customer = new Customer("AAA", "AAA");

        store.buy(customer, device1);
        store.buy(customer, device2);

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
