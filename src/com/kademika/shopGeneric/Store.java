package com.kademika.shopGeneric;

import com.kademika.shopGeneric.devices.*;

import java.util.ArrayList;
import java.util.List;

public class Store <T extends Device> {

    private List<Computer> computers = new ArrayList<>();
    private List<Notebook> notebooks = new ArrayList<>();
    private List<Printer> printers = new ArrayList<>();
    private List<Phone> phones = new ArrayList<>();
    private List<Tv> tvs = new ArrayList<>();

    private TransactionJournal transactionJournal = new TransactionJournal();

    public void addDevices(List<T> devices) {
        for (T device : devices) {
            addDevice(device);
        }
    }

    public void addDevices(T[] devices) {
        if (devices != null) {
            for (T device : devices) {
                addDevice(device);
            }
        }
    }

    public boolean addDevice(T device) {
        device.switchOn();
        if (device.isSwitchedOn() == false) {
            System.out.println("This is not accepted.");
            return false;
        }

        else {
            device.switchOff();

            if (device.getClass().getName() == Computer.class.getName()) {
                computers.add((Computer) device);
            } else if (device.getClass().getName() == Notebook.class.getName()) {
                notebooks.add((Notebook) device);
            } else if (device.getClass().getName() == Printer.class.getName()) {
                printers.add((Printer) device);
            } else if (device.getClass().getName() == Phone.class.getName()) {
                phones.add((Phone) device);
            } else if (device.getClass().getName() == Tv.class.getName()) {
                tvs.add((Tv) device);
            } else {
                System.out.println("Wrong goods.");
                return false;
            }
        }

//        transactionJournal.addTransaction();

        return true;
    }

    public void buy(Customer customer, Device device) {
        transactionJournal.addTransaction(customer, device);

        if (computers.contains(device)) {
            computers.remove(device);
        } else if (notebooks.contains(device)) {
            notebooks.remove(device);
        } else if (printers.contains(device)) {
            printers.remove(device);
        } else if (phones.contains(device)) {
            phones.remove(device);
        } else /*if (tvs.contains(device)) */{
            tvs.remove(device);
        }
    }
}
