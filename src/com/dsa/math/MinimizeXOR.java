package com.dsa.math;

public class MinimizeXOR {
//    Given two positive integers num1 and num2, find the integer x such that:
//
//    x has the same number of set bits as num2, and
//    The value x XOR num1 is minimal.

    public static void main(String[] args) {
        int num1 = 3, num2 = 5; //3
        System.out.println(minimizeXor(num1,num2));
    }
    static int minimizeXor(int num1, int num2) {
        int b2 = getBits(num2);
        int b1 = getBits(num1);

        if(b1==b2)
            return num1;

        StringBuilder s1 = new StringBuilder(Integer.toBinaryString(num1));
        // System.out.println(b1+"+"+b2+"+"+s1);
        s1.reverse();
        if(b1>b2){ //turn off bits
            int ext = b1-b2;
            int i=0;
            while(ext>0){
                while(s1.charAt(i)!='1')
                    i++;
                s1.setCharAt(i,'0');
                ext--;
            }
        }
        else{
            int rem = b2-b1;
            int i=0;
            while(rem>0 && i<s1.length()){
                if(s1.charAt(i)=='0'){
                    rem--;
                    s1.setCharAt(i,'1');
                }
                i++;
            }
            while(rem>0){
                s1.append('1');
                rem--;
            }
        }

        s1.reverse();
        // System.out.println(s1);
        return Integer.valueOf(s1.toString(),2);

    }

    static int getBits(int n){
        int ans=0;
        while(n>0){
            n= n&(n-1);
            ans++;
        }
        return ans;
    }
}
