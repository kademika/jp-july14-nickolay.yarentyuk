package com.kademika.day12.theory.multithreading.raceConditions;

public class GoodAtm implements Atm {

    @Override
    public void checkBalance(long accountId) {
        System.out.println(accountId + " going to withdraw some money.");
    }

    @Override
    public void withdrawalMoney(long accountId, int amount) {
        if (allowWithdrawal(accountId, amount)) {
            updateBalance(accountId, amount, TransactionType.WITHDRAWAL);
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
