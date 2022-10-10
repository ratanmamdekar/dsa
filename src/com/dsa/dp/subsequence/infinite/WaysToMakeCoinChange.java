package com.dsa.dp.subsequence.infinite;

import java.util.Arrays;

public class WaysToMakeCoinChange {
    public static void main(String[] args) {
        int[] denomination = {1, 2, 3, 4};
        int val = 5;
        // ans = 6;
        System.out.println(WaysToMakeCoinChangeMemo(denomination,val));
        System.out.println(WaysToMakeCoinChangeTabu(denomination,val));
    }

    private static long WaysToMakeCoinChangeTabu(int[] denominations, int value) {
        long [][] dp = new long[denominations.length][value+1];

        for(int v=0;v<=value;v++)
            if(v%denominations[0]==0)
                dp[0][v]=1;

        for(int i=1;i<denominations.length;i++)
            for(int v=0;v<=value;v++){
                long take=0,notTake;
                if(denominations[i]<=v)
                    take = dp[i][v-denominations[i]];
                notTake = dp[i-1][v];
                dp[i][v]=take+notTake;
            }

        return dp[denominations.length-1][value];
    }

    private static long WaysToMakeCoinChangeMemo(int[] denomination, int val) {
        long[][] dp = new long[denomination.length][val+1];
        for(long[] row:dp)
            Arrays.fill(row,-1);

        return helper(denomination.length-1, denomination,val,dp);
    }

    public static long helper(int idx, int[] d,int v,long [][] dp){
        if(idx==0){
            if (0==v%d[0]||v==0)
                return 1;
            else
                return 0;
        }
        else{
            if(dp[idx][v]!=-1)
                return dp[idx][v];

            long take=0,notTake;
            if(d[idx]<=v)
                take = helper(idx,d,v-d[idx],dp);
            notTake = helper(idx-1,d,v,dp);
            return dp[idx][v]=take+notTake;
        }
    }
}
