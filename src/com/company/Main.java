package com.company;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        Running r1 = new Running(1, 350000);
        Running r2 = new Running(350001, 500000);

        Thread tr1 = new Thread(r1);
        tr1.setName("tr1");
        Thread tr2 = new Thread(r2);
        tr2.setName("tr2");

        tr1.start();
        tr2.start();
    }
}

class Running implements Runnable {

    private final int fran;
    private final int till;
    private int primeCounter;

    public Running(int fran, int till) {
        this.fran = fran;
        this.till = till;

    }

    @Override
    public void run() {
        int num;
        for (int i = fran; i <= till; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                primeCounter++;
            }

        }
        if (Objects.equals(Thread.currentThread().getName(), "tr1")) {

            System.out.println(ThreadColor.ANSI_RED + Thread.currentThread().getName() + " Antal Primtal i denna tråd : " + primeCounter);
        } else {
            System.out.println(ThreadColor.ANSI_GREEN + Thread.currentThread().getName() + " Antal Primtal i denna tråd : " + primeCounter);
        }
    }
}

class ThreadColor {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
}

