package com.dsa.dp.subsequence.infinite;

import java.util.Arrays;

public class minimumCoinsForTarget {
    public static void main(String[] args) {
//        int[] coins = {10,2,5,1};
//        int amount =27;
        int[] coins = {3,5,7};
        int amount =11;

        System.out.println(simpleMinimumCoinsForTarget(coins,amount));
        System.out.println(MinimumCoinsForTargetMemo(coins,amount));
        System.out.println(MinimumCoinsForTargetTabu(coins,amount));
    }

    private static int MinimumCoinsForTargetTabu(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];

        for(int j=0;j<=amount;j++)
            dp[0][j] = j%coins[0]==0 ? j/coins[0] : (int) 1e9;

        for(int  i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                int take=Integer.MAX_VALUE,notTake;

                notTake = dp[i-1][j];
                if(coins[i]<=j)
                    take = 1 + dp[i][j-coins[i]];

                dp[i][j] = Math.min(notTake,take);
            }
        }

        return dp[coins.length-1][amount];
    }

    private static int MinimumCoinsForTargetMemo(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return helperMemo(coins,coins.length-1,amount,dp);
    }

    private static int helperMemo(int[] coins, int idx, int amount, int[][] dp) {
        if(idx==0){
            if(amount%coins[0]==0)
                return amount/coins[0];
            return (int) 1e9;
        }
        else {
            if(dp[idx][amount]!=-1)
                return dp[idx][amount];
            int take=Integer.MAX_VALUE,notTake;

            if(coins[idx]<=amount)
                take = 1+helperMemo(coins,idx,amount-coins[idx],dp);
            notTake = helperMemo(coins,idx-1,amount,dp);

            return dp[idx][amount] = Math.min(take,notTake);
        }
    }

    private static int simpleMinimumCoinsForTarget(int[] coins, int amount) {
        return helper(coins,coins.length-1,amount);
    }

    private static int helper(int[] coins, int idx, int amount) {
        if(idx==0){
            if(amount%coins[0]==0)
                return amount/coins[0];
            return (int) 1e9;
        }
        else {
            int take=Integer.MAX_VALUE,notTake;

            if(coins[idx]<=amount)
                take = 1+helper(coins,idx,amount-coins[idx]);
            notTake = helper(coins,idx-1,amount);

            return Math.min(take,notTake);
        }
    }
}
