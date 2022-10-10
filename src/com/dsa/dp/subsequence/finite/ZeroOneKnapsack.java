package com.dsa.dp.subsequence.finite;

import java.util.Arrays;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int  W = 8;
        int wt[] = {1, 3, 5, 7};
        int val[] = {1, 3, 4, 5};
        // ans = 11
        System.out.println(knapSackMemo(W,val,wt));
        System.out.println(knapSackTabu(W,val,wt));
    }

    private static int knapSackTabu(int W, int[] val, int[] wt) {
        int dp[][] = new int[val.length][W+1];
        for(int remainingWeight = wt[0];remainingWeight<W;remainingWeight++)
            dp[0][remainingWeight]=val[0];

        for (int idx=1;idx< val.length;idx++)
            for (int remainingWeight=0;remainingWeight<=W;remainingWeight++){
                int pick=Integer.MIN_VALUE,notPick;

                notPick = dp[idx-1][remainingWeight];
                if(wt[idx]<=remainingWeight)
                    pick = val[idx] + dp[idx-1][remainingWeight-wt[idx]];

                dp[idx][remainingWeight] = Math.max(pick,notPick);
            }

        return dp[val.length-1][W];
    }

    private static int knapSackMemo(int w, int[] val, int[] wt) {
        int dp[][] = new int[val.length][w+1];
        for(int[] row :dp)
            Arrays.fill(row,-1);

        return helper(val.length-1,w,val,wt,dp);
    }

    private static int helper(int idx, int remainingWeight, int[] val, int[] wt,int dp[][]) {
        if(idx==0){
            if (wt[idx]<=remainingWeight)
                return val[idx];
            return 0;
        }
        if(dp[idx][remainingWeight]!=-1)
            return dp[idx][remainingWeight];
        int pick=Integer.MIN_VALUE,notPick;

        notPick = helper(idx-1,remainingWeight,val,wt,dp);
        if(wt[idx]<=remainingWeight)
            pick = val[idx] + helper(idx-1, remainingWeight-wt[idx], val, wt,dp);

        return dp[idx][remainingWeight] = Math.max(pick,notPick);

    }
}
