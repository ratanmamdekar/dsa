package com.dsa.dp.array;

import java.util.Arrays;

public class BuyAndSellAtMaxKTimes {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4}; // for k = 2, ans 6 (0->3 + 1->4)
        int k=3;
        System.out.println(maxProfitMemo(prices,k));
        System.out.println(maxProfitTabu(prices,k));
    }

    private static int maxProfitTabu(int[] prices,int k) {
        int[][][] dp = new int[prices.length+1][2][k+1];

        for (int ind=prices.length-1;ind>=0;ind--){
            for (int buy =0;buy<=1;buy++){
                for (int buyleft=0;buyleft<=k;buyleft++){
                    int profit=0;
                    if(buy==1 ){
                        if(buyleft>0)
                            profit = Math.max(-prices[ind] + dp[ind+1][0][buyleft-1],  dp[ind+1][1][buyleft]);
                    }
                    else
                        profit= Math.max(prices[ind] + dp[ind+1][1][buyleft],+ dp[ind+1][0][buyleft] );

                    dp[ind][buy][buyleft]=profit;
                }
            }

        }

        return dp[0][1][k];
    }

    public static int maxProfitMemo(int[] prices,int k) {
        int[][][] dp = new int[prices.length][2][k+1];

        for(int[][]mat : dp)
            for(int[]row : mat)
                Arrays.fill(row,-1);

        return helper(0,prices.length,prices,1,k,dp);
    }

    public static int helper(int ind,int n, int[] p,int buy,int buyleft,int[][][] dp){
        if(ind==n)
            return 0;

        else{
            if(dp[ind][buy][buyleft]!=-1)
                return dp[ind][buy][buyleft];
            int profit=0;
            if(buy==1 ){
                if(buyleft>0)
                    profit = Math.max(-p[ind] + helper(ind+1,n,p,0,buyleft-1,dp), 0 + helper(ind + 1, n, p, 1, buyleft, dp));
            }
            else
                profit= Math.max(p[ind] + helper(ind+1,n,p,1,buyleft,dp),0 + helper(ind+1,n,p,0,buyleft,dp));

            return dp[ind][buy][buyleft]=profit;
        }
    }

}
