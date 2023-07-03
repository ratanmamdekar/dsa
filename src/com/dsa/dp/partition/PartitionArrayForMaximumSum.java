package com.dsa.dp.partition;

import java.util.Arrays;

/*Given an integer array arr, partition the array into (contiguous) subarrays of length at most k.
After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 */
public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10}; // 84 - [15,15,15,9,10,10,10]
        int k = 3;

        System.out.println(maxSumAfterPartitioning(arr,k));
        System.out.println(maxSumAfterPartitioningMemo(arr,k));
        System.out.println(maxSumAfterPartitioningTabu(arr,k));
    }

    private static int maxSumAfterPartitioningTabu(int[] arr, int k) {
        int[] dp  = new int[arr.length+1];

        for(int idx = arr.length-1;idx>=0;idx--){
            int ans=0,max=0;
            for(int i=idx;i<idx+k && i<arr.length;i++){
                max=Math.max(max,arr[i]);
                int temp = (i-idx+1)*max + dp[i+1];
                ans = Math.max(ans,temp);
            }
            dp[idx] = ans;
        }
        return dp[0];
    }

    private static int maxSumAfterPartitioningMemo(int[] arr, int k) {
        int[] dp  = new int[arr.length];
        Arrays.fill(dp,-1);
        return helperMemo(arr,k,0,dp);
    }

    static int helperMemo(int[] arr, int k,int idx,int[] dp){
        if(idx>=arr.length)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int ans=0,max=0;
        for(int i=idx;i<idx+k && i<arr.length;i++){
            max=Math.max(max,arr[i]);
            int temp = (i-idx+1)*max + helperMemo(arr,k,i+1,dp);
            ans = Math.max(ans,temp);
        }

        return dp[idx] = ans;
    }
    static int maxSumAfterPartitioning(int[] arr, int k) {
        return helper(arr,k,0);
    }
    static int helper(int[] arr, int k,int idx){
        if(idx>=arr.length)
            return 0;

        int ans=0,max=0;
        for(int i=idx;i<idx+k && i<arr.length;i++){
            max=Math.max(max,arr[i]);
            int temp = (i-idx+1)*max + helper(arr,k,i+1);
            ans = Math.max(ans,temp);
        }

        return ans;
    }
}
