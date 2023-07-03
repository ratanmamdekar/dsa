package com.mutilthread;

public class HelloWorldThread {


    public static void main(String[] args) {

//        Thread t = new Hello();
        Thread t = new Thread(new Hello());
//        Thread t = new Thread(new Thread(new Hello()));
        System.out.println(Thread.activeCount());
        System.out.println("is thread alive before start? " + t.isAlive());
        System.out.println("is thread alive before start? " + t.isAlive());
        System.out.println("is thread alive before start? " + t.isAlive());
        t.start();
        System.out.println("is thread alive after start? " + t.isAlive());
        System.out.println("is thread alive after start? " + t.isAlive());
        System.out.println("is thread alive after start? " + t.isAlive());
        System.out.println("is thread alive after start? " + t.isAlive());
        System.out.println("is thread alive after start? " + t.isAlive());
        System.out.println("is thread alive after start? " + t.isAlive());
        System.out.println("is thread alive after start? " + t.isAlive());
        System.out.println("is thread alive after start? " + t.isAlive());
    }
}
