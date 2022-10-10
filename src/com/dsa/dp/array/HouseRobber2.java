package com.dsa.dp.array;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums)); //3
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        return Math.max(robMemo(Arrays.copyOfRange(nums,0,n-1)),robMemo(Arrays.copyOfRange(nums,1,n)));
    }

    public static int robMemo(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp,-1);

        return maxi(nums,dp,n-1);
    }

    static int maxi(int[] nums,int[] dp,int n){
        if(n<0)
            return 0;
        if(n==0)
            return nums[0];

        if(dp[n]!=-1)
            return dp[n];

        int pick = nums[n] + maxi(nums,dp,n-2);
        int notpick = 0 + maxi(nums,dp,n-1);

        dp[n] = Math.max(pick,notpick);

        return dp[n];
    }
}
