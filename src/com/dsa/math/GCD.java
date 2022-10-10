package com.dsa.math;

public class GCD {
    public static void main(String[] args) {
        int a=18,b=12;

        System.out.println("GCD of "+a+","+b+" is "+gcd(a,b));
        System.out.println("LCM of "+a+","+b+" is "+lcm(a,b));
    }

    private static int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }

    private static int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}
