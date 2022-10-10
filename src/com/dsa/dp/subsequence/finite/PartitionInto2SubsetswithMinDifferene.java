package com.dsa.dp.subsequence.finite;

import java.util.Arrays;

public class PartitionInto2SubsetswithMinDifferene {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,4}; // ans 0
        int nums2[] = {8,6,5};   // ans 3

        System.out.println(minSubsetSumDifference(nums1,4));
        System.out.println(minSubsetSumDifference(nums2,3));
    }

    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        boolean[][] dp = new boolean[n][sum+1];

        for(int i =0;i<n;i++)
            dp[i][0]=true;
        dp[0][arr[0]]=true;

        for(int i =1;i<n;i++)
            for(int j=sum;j>=0;j--){
                boolean take=false,notTake;
                notTake = dp[i-1][j];
                if(j-arr[i]>=0)
                    take = dp[i-1][j-arr[i]];

                dp[i][j]=notTake||take;
            }
        int min = sum;
        for(int j=0;j<=sum;j++)
            if(dp[n-1][j])
                min = Math.min(min,Math.abs(sum-2*j));

        return min;

    }
}
