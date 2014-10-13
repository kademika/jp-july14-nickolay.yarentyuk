package com.kademika.day12.theory.multithreading.raceConditions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LegacyAtm implements Atm {

    private Lock accountLock;

    public LegacyAtm() {

    }

    @Override
    public void checkBalance(long accountId) {
        System.out.println(accountId + " going to withdraw some money.");
    }

    @Override
    public /*synchronized */void withdrawalMoney(long accountId, int amount) {  //  synchronized - variant 1
        try {
            if (allowWithdrawal(accountId, amount)) {
                synchronized (this) {   //  synchronized - variant 2
                    updateBalance(accountId, amount, TransactionType.WITHDRAWAL);
                }
            }
        } finally {
        }
    }

    private boolean allowWithdrawal(long accountId, int amount) {
        return true;
    }

    private void updateBalance(long accountId, int amount, TransactionType type) {
        System.out.println("Successful " + type + " account: " + accountId + " ammount: " + amount);
    }

    enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }
}
