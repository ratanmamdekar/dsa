package com.dsa.concurrency;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

public class printInOrder {
    private static CountDownLatch cdl1 = new CountDownLatch(1);
    private static CountDownLatch cdl2 = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {

        Thread first = new Thread(new First());
//        Runnable first = new First();
        Thread second = new Thread(new Second());
        Thread third = new Thread(new Third());
        int[] order = {2,3,1,4};
        for(int o : order){
            if(o==1){
                first.start();
//                first.run();
//                System.out.println("outside 1st");
            }else if(o==2){
                second.start();
//                System.out.println("outside 2nd");
            }else if(o==3){
                third.start();
//                System.out.println("outside 3rd");
            }
        }
    }

    static void first(){
        System.out.println("first");
        cdl1.countDown();
    }
    static void second() throws InterruptedException {
        cdl1.await();
        System.out.println("second");
        cdl2.countDown();
    }
    static void third() throws InterruptedException {
        cdl2.await();
        System.out.println("third");
    }

    static class First implements Runnable{

        @Override
        public void run() {
            first();
        }
    }

    static class Second implements Runnable{

        @SneakyThrows
        @Override
        public void run() {
            second();
        }
    }

    static class Third implements Runnable{

        @SneakyThrows
        @Override
        public void run() {
            third();
        }
    }
}
