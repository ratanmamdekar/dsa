package com.dsa.math;

public class ModularMultiplicativeInverse {
    public static void main(String[] args) {
        int a=100,b=10,m=7;
//        need to find (a/b) %m  ==3
//        but (a%m / b%m) %m = (2 / 3) %3

//        instead, we need (a%m * MMI(b)) %m

        int ans = (a%m * MMI(b,m))%m;
        System.out.println("(a/b) %m = "+ans);

    }

    private static int MMI(int b, int m) {
        return BinaryExponentiation.binaryExponentiationRecursive(b,m-2,m);
    }
}
