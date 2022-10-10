package com.dsa.dp.array;

import java.util.Arrays;

public class countWaysStairs {
    public static void main(String[] args) {
        int n = 3;

        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        int ans = count(n,dp);
        System.out.println(ans);
    }

    private static int count(int n, int[] dp) {
        if(n<=1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];

        return dp[n] = count(n-1,dp)+count(n-2,dp);
    }
}
