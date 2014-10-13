package com.kademika.shopGeneric;

import com.kademika.shopGeneric.devices.Device;

import java.util.ArrayList;
import java.util.List;

public class TransactionJournal {

    GuiTransactionJournal guiTransactionJournal;

    List<Transaction> transactions = new ArrayList<>();

    public TransactionJournal() {
        guiTransactionJournal = new GuiTransactionJournal(transactions);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    };

    public void addTransaction(Customer customer, Device device) {
        Transaction transaction = new Transaction(1, customer, device);
        transactions.add(transaction);
    };
}
