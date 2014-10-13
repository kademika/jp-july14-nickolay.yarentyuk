package com.kademika.day12.theory.multithreading.raceConditions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BadAtm implements Atm {

    private Lock accountLock;

    public BadAtm() {
        accountLock = new ReentrantLock();
    }

    @Override
    public void checkBalance(long accountId) {
        System.out.println(accountId + " going to withdraw some money.");
    }

    @Override
    public void withdrawalMoney(long accountId, int amount) {
        accountLock.lock();

        try {
            if (allowWithdrawal(accountId, amount)) {
                updateBalance(accountId, amount, TransactionType.WITHDRAWAL);
            }
        } finally {
            accountLock.unlock();
        }
    }

    private boolean allowWithdrawal(long accountId, int amount) {
        return false;
    }

    private void updateBalance(long accountId, int amount, TransactionType type) {
        System.out.println("Successful " + type + " account: " + accountId + " ammount: " + amount);
    }

    enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }
}
