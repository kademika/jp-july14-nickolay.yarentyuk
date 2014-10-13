package com.kademika.day12.theory.multithreading.raceConditions;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RaceConditions {

    public static void main(String[] args) {

        Random random = new Random();

        long husband = 1111;
        long wife = 2222;

//        Atm atm = new GoodAtm();
        Atm atm = new BadAtm();
//        Atm atm = new LegacyAtm();

        Set<Runnable> threads = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            threads.add(createWidthdrawalThread(atm, wife, random.nextInt(1000)));
            threads.add(createWidthdrawalThread(atm, husband, random.nextInt(1000)));
        }

        for (Runnable r : threads) {
            new Thread(r).start();
        }
    }

    private static Runnable createWidthdrawalThread(final Atm atm, final long accountId, final int amount) {
        return new Runnable() {

            @Override
            public void run() {
                atm.checkBalance(accountId);
                atm.withdrawalMoney(accountId,amount);
            }
        };
    }
}
