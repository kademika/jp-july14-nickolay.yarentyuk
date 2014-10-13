package com.kademika.day12.theory.multithreading.raceConditions;

public interface Atm {

    public void checkBalance(long accountId);

    public void withdrawalMoney(long accountId, int amount);
}
