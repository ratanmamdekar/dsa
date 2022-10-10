package com.dsa.dp.array;

import java.util.Arrays;

public class frogJump {
    public static void main(String[] args) {
        int[] nums =new int[]{7, 4, 4, 2, 6, 6, 3, 4 };
        System.out.println(frogJump(8,nums)); //expected 7
    }

    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return jump(n-1,dp,heights);

    }

    public static int jump(int n, int dp[], int h[]){
        if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int left,right;
        left = jump(n-1,dp,h) + Math.abs(h[n]-h[n-1]);
        if(n>1)
            right = jump(n-2,dp,h) + Math.abs(h[n]-h[n-2]);
        else
            right = Integer.MAX_VALUE;
        dp[n] = Math.min(left,right);
        return dp[n];
    }
}
