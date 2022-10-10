package com.dsa.dp.lonngestIncreasingSubsequence;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums={1,3,5,4,7}; // count 2 of size 4(1,3,5,7 and 1,3,4,7)
        System.out.println(findNumberOfLIS(nums));
    }


    public static int findNumberOfLIS(int[] nums) {
        int n =nums.length;
        int[] dp = new int[n],cnt = new int[n];
        int max=1;
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    cnt[i]=cnt[j];
                }
                else if (nums[i]>nums[j] && dp[i]==dp[j]+1){
                    cnt[i]+=cnt[j];
                }
            }
            max = Math.max(max,dp[i]);
        }
        int ans =0;
        for(int i=0;i<n;i++)
            if(dp[i]==max)
                ans+=cnt[i];
        return ans;
    }
}
