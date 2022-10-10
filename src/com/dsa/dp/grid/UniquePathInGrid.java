package com.dsa.dp.grid;

public class UniquePathInGrid {
    public static void main(String[] args) {
        System.out.println(simpleUniquePath(3,4));
        System.out.println(UniquePathMemo(500,100));

        System.out.println((int)1.5e9);
    }

    private static int UniquePathMemo(int m, int n) {
        int [][] dp = new int[m][n];
        return helperMemo(m-1,n-1,dp);
    }

    private static int helperMemo(int i, int j, int[][] dp) {
        if(i<0 || j<0)
            return 0;
        else if(i==0 && j==0)
            return 1;
        if(dp[i][j]!=0)
            return dp[i][j];
        int left= helperMemo(i,j-1,dp);
        int  up= helperMemo(i-1,j,dp);

        return dp[i][j] = up+left;
    }

    private static int simpleUniquePath(int m, int n) {
        return helper(m-1,n-1);
    }

    private static int helper(int i, int j) {
        if(i<0 || j<0)
            return 0;
        else if(i==0 && j==0)
            return 1;

        int l = helper(i,j-1);
        int u = helper(i-1,j);

        return l+u;
    }
}
