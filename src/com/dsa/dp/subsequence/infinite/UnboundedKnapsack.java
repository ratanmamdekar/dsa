package com.dsa.dp.subsequence.infinite;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int N = 4, W = 8;
        int val[] = {1, 4, 5, 7};
        int wt[] = {1, 3, 4, 5};
        // ans = 11
        System.out.println(knapSackMemo(N,W,val,wt));
        System.out.println(knapSackTabu(N,W,val,wt));
    }

    private static int knapSackTabu(int N, int W, int[] val, int[] wt) {
        int[][] dp = new int [N][W+1];

        for(int w =wt[0];w<=W;w++)
            dp[0][w]=w/wt[0]*val[0];

        for(int n =1;n<N;n++)
            for (int w=0;w<=W;w++){

                int take=Integer.MIN_VALUE,notTake;

                notTake = dp[n-1][w];

                if(wt[n]<=w)
                    take = val[n] + dp[n][w-wt[n]];

                dp[n][w] = Math.max(take,notTake);
            }

        return dp[N-1][W];
    }

    static int knapSackMemo(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp = new int [N][W+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);

        return helper(N-1,W,val,wt,dp);
    }

    public static int helper(int n, int W, int val[], int wt[],int[][] dp){
        if(n==0){
            if(wt[n]<=W){
                return W/wt[n]*val[n];
            }
            return 0;
        }
        else{
            if(dp[n][W]!=-1)
                return dp[n][W];
            int take=Integer.MIN_VALUE,notTake;

            notTake = helper(n-1,W,val,wt,dp);

            if(wt[n]<=W)
                take = val[n] + helper(n,W-wt[n],val,wt,dp);

            return dp[n][W] = Math.max(take,notTake);
        }
    }
}
