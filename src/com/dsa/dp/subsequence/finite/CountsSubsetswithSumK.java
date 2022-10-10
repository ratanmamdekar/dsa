package com.dsa.dp.subsequence.finite;

import java.util.Arrays;

public class CountsSubsetswithSumK {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,4,5}; // ans 3
        int nums2[] = {1,2,3};   // ans 2

        System.out.println(countWays(nums1,5,5));
        System.out.println(countWays(nums2,3,3));
    }

    public static int countWays(int[] arr, int n,int target) {
//        int sum = Arrays.stream(arr).sum();
        int[][] dp = new int[n][target+1];

        for(int i =0;i<n;i++)
            dp[i][0]=1;
        if(arr[0]<target)
            dp[0][arr[0]]=1;

        for(int i =1;i<n;i++)
            for(int j=0;j<=target;j++){
                int take=0,notTake;
                notTake = dp[i-1][j];
                if(j-arr[i]>=0)
                    take = dp[i-1][j-arr[i]];
                dp[i][j]=notTake+take;
            }
        return dp[n-1][target];

    }
}
