package com.mutilthread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NumberPrinterExecutor {

    public static void main(String[] args) {
//        Executor executor = Executors.newFixedThreadPool(10);
        Executor executor = Executors.newSingleThreadExecutor();
        for (int i=1;i<=100;i++){
            executor.execute(new NumberPrinter(i));
        }
    }
}
