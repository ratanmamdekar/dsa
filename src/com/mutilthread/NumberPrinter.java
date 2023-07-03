package com.mutilthread;

public class NumberPrinter implements Runnable{

    private int number;

    NumberPrinter(int number){
        this.number=number;
    }

    @Override
    public void run() {
        System.out.println(number + " + " + Thread.currentThread().getName());
    }
}