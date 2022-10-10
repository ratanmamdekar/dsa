package com.dsa.dp.array;

import java.util.Arrays;

public class BuyAndSellUnlimtedWithCooldown {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2}; //ans 3 - ( 1->2 + 0->2 )

        System.out.println(maxProfitSimple(prices));
        System.out.println(maxProfitMemo(prices));
        System.out.println(maxProfitTabu(prices));
    }

    private static int maxProfitTabu(int[] prices) {
        int dp[][] = new int[prices.length+1][3];

        for (int day = prices.length-1;day>=0;day--)
            for (int buy = 0;buy<=2;buy++){
                if(buy==1)
                    dp[day][buy] = Math.max(-prices[day]+dp[day+1][0],dp[day+1][1]);
                else if(buy==0)
                    dp[day][buy] = Math.max(prices[day]+dp[day+1][2],dp[day+1][0]);
                else
                    dp[day][2] = dp[day+1][1];

            }

        return dp[0][1];
    }

    private static int maxProfitMemo(int[] prices) {
        int dp[][] = new int[prices.length][3];

        for(int[]row:dp)
            Arrays.fill(row,-1);

        return helperMemo(0,1,prices,dp);
    }

    private static int helperMemo(int day, int buy, int[] prices, int[][] dp) {
        if(day ==prices.length)
            return 0;

        if(dp[day][buy]!=-1)
            return dp[day][buy] ;

        if(buy==1)
            return dp[day][buy] = Math.max(-prices[day]+helperMemo(day+1,0,prices,dp),
                    helperMemo(day+1,1,prices,dp));
        else if(buy==0)
            return dp[day][buy] = Math.max(+prices[day]+helperMemo(day+1,2,prices,dp),
                    helperMemo(day+1,0,prices,dp));
        else
            return dp[day][buy] = helperMemo(day+1,1,prices,dp);
    }


    public static int maxProfitSimple(int[] prices) {
        return helper(0,1,prices);
    }

    public static int helper(int day, int buy,int[] prices){
        if(day ==prices.length)
            return 0;

        if(buy==1)
            return Math.max(-prices[day]+helper(day+1,0,prices),helper(day+1,1,prices));
        else if(buy==0)
            return Math.max(+prices[day]+helper(day+1,-1,prices),helper(day+1,0,prices));
        else
            return helper(day+1,1,prices);

    }
}
