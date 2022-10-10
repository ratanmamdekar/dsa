package com.dsa.dp.partition;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BurstBalloons {
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};


        System.out.println(maxCoinsMemo(nums));
        System.out.println(maxCoinsTabu(nums));
    }

    private static int maxCoinsTabu(int[] nums) {
        List<Integer> coins = Arrays.stream(nums).boxed().collect(Collectors.toList());
        coins.add(1);
        coins.add(0,1);

        int[][] dp = new int[coins.size()][coins.size()];

        for(int i=coins.size()-2;i>=1;i--){
            for (int j=i;j<=coins.size()-2;j++){
                int ans=0,temp;
                for (int k=i;k<=j;k++){
                    temp = coins.get(k)*coins.get(i-1)*coins.get(j+1) + dp[i][k-1] + dp[k+1][j];
                    ans = Math.max(ans,temp);
                }
                dp[i][j] =ans;
            }
        }
        return dp[1][coins.size()-2];
    }

    static int maxCoinsMemo(int[] nums) {
        List<Integer> coins = Arrays.stream(nums).boxed().collect(Collectors.toList());
        coins.add(1);
        coins.add(0,1);

        int[][] dp = new int[coins.size()][coins.size()];

        return helper(coins,1,coins.size()-2,dp);
    }

    static int helper(List<Integer> coins, int i, int j,int[][] dp){
        if(i>j)
            return 0;
        if(dp[i][j]!=0)
            return dp[i][j];
        int ans=0,temp;

        for(int k=i;k<=j;k++){
            temp = coins.get(k)*coins.get(i-1)*coins.get(j+1) +  helper(coins,i,k-1,dp) + helper(coins,k+1,j,dp);
            ans = Math.max(ans,temp);
        }

        return dp[i][j]= ans;
    }
}
