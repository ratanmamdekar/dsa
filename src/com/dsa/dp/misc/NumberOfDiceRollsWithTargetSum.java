package com.dsa.dp.misc;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
//        int n = 2, k = 6, target = 7; // 6 (1,6 + 2,5 + 3,4 + 4,3 + 5,2 + 6,1)
        int n = 30, k = 30, target = 500;  // 222616187
        System.out.println(numRollsToTarget(n,k,target));
    }

    static int numRollsToTarget(int n, int k, int target) {
        if(n>target)
            return 0;
        int[][] dp = new int[n+1][target+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return helper(n,k,target,dp);
    }

    static int helper(int n, int k, int target,int[][] dp) {
        if(target<0)
            return 0;
        if(n==0){
            if(target==0)
                return 1;
            return 0;
        }
        if(dp[n][target]!=-1)
            return dp[n][target];

        int mod = (int)1e9+7;
        int ways=0;
        for(int i=1;i<=k;i++){
            ways= (ways+helper(n-1,k,target-i,dp))%mod;
        }

        return dp[n][target]=ways;
    }
}
