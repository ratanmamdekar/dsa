package com.dsa.dp.subsequence.infinite;

import java.util.Arrays;

public class rodCutting {
    public static void main(String[] args) {
        int[] val = {2,5,7,8,10};  // 12

        System.out.println(rodCuttingMemo(val,val.length));
        System.out.println(rodCuttingTabu(val,val.length));
    }

    private static int rodCuttingTabu(int[] val, int length) {
        int[][] dp = new  int[length][length+1];

        for(int j =0;j<length+1;j++)
            dp[0][j] = j*val[0];

        for(int i=1;i<length;i++)
            for(int j =0;j<length+1;j++){
                int notTake,take=Integer.MIN_VALUE;
                notTake = dp[i-1][j];

                int rodLength = i+1;
                if(rodLength<=j)
                    take = val[i] + dp[i][j-rodLength];

                dp[i][j] = Math.max(take,notTake);
            }

        return dp[length-1][length];
    }

    private static int rodCuttingMemo(int[] val, int length) {
        int[][] dp = new  int[length][length+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);

        return helperMemo(length-1,length,val,dp);
    }

    private static int helperMemo(int i, int sizeRemaining, int[] val, int[][] dp) {
        if(i==0){
            return val[0]*sizeRemaining;
        }
        else {
            if(dp[i][sizeRemaining]!=-1)
                return dp[i][sizeRemaining];

            int notTake,take=Integer.MIN_VALUE;
            notTake = helperMemo(i-1, sizeRemaining, val, dp);

            int rodLength = i+1;
            if(rodLength<=sizeRemaining)
                take = val[i] + helperMemo(i,sizeRemaining-rodLength,val,dp);

            return dp[i][sizeRemaining] = Math.max(take,notTake);
        }
    }


}
