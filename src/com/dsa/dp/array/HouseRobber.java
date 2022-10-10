package com.dsa.dp.array;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1,6};

        System.out.println(robMemo(nums)); //expected 17
        System.out.println(robTabu(nums)); //expected 17
    }

    private static int robTabu(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i =2;i<n;i++){
            int pick  = nums[i] + dp[i-2];
            int notpick = 0 + dp[i-1];

            dp[i]= Math.max(pick,notpick);
        }

        return dp[n-1];
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
