package com.dsa.dp.grid;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumFallingPathSum {
    static final int max = (int)1e9;
    public static void main(String[] args) {
        int[][] matrix= {{2,1,3},{6,5,4},{7,8,9}};

        System.out.println(simpleMinFallingPathSum(matrix));
        System.out.println(minFallingPathSumMemo(matrix));
        System.out.println(minFallingPathSumTabu(matrix));
    }

    private static int minFallingPathSumTabu(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        dp[n-1] = Arrays.copyOf(matrix[n-1],n);
        for(int i=n-2;i>=0;i--){
            for (int j =0;j<n;j++){
                int left=Integer.MAX_VALUE,right=left,down;
                if (j>0) left = dp[i+1][j-1];
                down = dp[i+1][j];
                if (j+1<n) right = dp[i+1][j+1];

                dp[i][j] = matrix[i][j]+Math.min(left,Math.min(down,right));
            }
        }
        return IntStream.of(dp[0]).min().getAsInt();
//        return Arrays.stream(dp[0]).min().getAsInt();
    }

    private static int minFallingPathSumMemo(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int[] row:dp)
            Arrays.fill(row,Integer.MAX_VALUE);
        int res  =Integer.MAX_VALUE,temp;
        for(int i=0;i<n;i++){
            temp = helperMemo(0,i,matrix,n,dp);
            // System.out.println(i+"+"+temp);
            res= Math.min(res,temp);
        }
        return res;
    }

    private static int helperMemo(int i, int j, int[][] matrix, int n, int[][] dp) {
        if(j<0||j>=n)
            return max;
        if(i==n-1)
            return matrix[i][j];

        if(dp[i][j]!=Integer.MAX_VALUE)
            return dp[i][j];

        int left = matrix[i][j] + helperMemo(i+1,j-1,matrix,n,dp);
        int down = matrix[i][j] + helperMemo(i+1,j,matrix,n,dp);
        int right = matrix[i][j] + helperMemo(i+1,j+1,matrix,n,dp);

        return dp[i][j] = Math.min(left,Math.min(down,right));
    }

    public static int simpleMinFallingPathSum(int[][] matrix) {
        int res  =Integer.MAX_VALUE;
        int n = matrix.length;
        int temp;
        for(int i=0;i<n;i++){
            temp = helper(0,i,matrix,n);
            // System.out.println(i+"+"+temp);
            res= Math.min(res,temp);
        }
        return res;
    }

    static int helper(int i, int j, int[][] matrix, int n){
        if(j<0||j>=n)
            return max;
        if(i==n-1)
            return matrix[i][j];

        int left = matrix[i][j] + helper(i+1,j-1,matrix,n);
        int down = matrix[i][j] + helper(i+1,j,matrix,n);
        int right = matrix[i][j] + helper(i+1,j+1,matrix,n);

        return Math.min(left,Math.min(down,right));
    }
}
