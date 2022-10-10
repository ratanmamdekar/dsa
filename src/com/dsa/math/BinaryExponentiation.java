package com.dsa.math;

public class BinaryExponentiation {
    static int mod = (int) (1e9+7);
    public static void main(String[] args) {
	// write your code here
        int a=3,b=30;

        System.out.println(Math.pow(a,b)%mod);
        System.out.println(binaryExponentiationRecursive(a,b,mod));
        System.out.println(binaryExponentiationIterative(a,b,mod));
    }

    public static int binaryExponentiationIterative(int a, int b,int mod) {
        int ans =1;
        while(b>0){
            if((b&1)==1)
                ans = (int)(((long) ans * a)%mod);
            a=(int)(((long) a * a)%mod);
            b = b >> 1;
        }
        return ans;
    }

    public static int binaryExponentiationRecursive(int a, int b,int mod) {
        if(b==0)
            return 1;
        int res = binaryExponentiationRecursive(a,b/2,mod);
        if((b&1)==1)
            return (int)((a*((long)res*res)%mod)%mod);
        else
            return (int)(((long)res*res)%mod) ;
    }
}
