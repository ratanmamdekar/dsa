package com.dsa.dp.lonngestIncreasingSubsequence;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,11,2,10,4,5,2,1}; // ans = 6

        System.out.println(LBS(nums));
    }

    private static int LBS(int[] nums) {
        int n = nums.length;

        int[] dpLeftToRight = new int[n],dpRightToLeft = new int[n];
        for(int ind=0;ind<n;ind++){
            dpLeftToRight[ind]=1;
            for (int prev =0;prev<ind;prev++)
                if(nums[prev]<nums[ind] && dpLeftToRight[ind]<1+dpLeftToRight[prev]){
                    dpLeftToRight[ind] = 1 + dpLeftToRight[prev];
                }
        }

        for(int ind=n-1;ind>=0;ind--){
            dpRightToLeft[ind]=1;
            for (int prev =ind+1;prev<n;prev++)
                if(nums[prev]<nums[ind] && dpRightToLeft[ind]<1+dpRightToLeft[prev]){
                    dpRightToLeft[ind] = 1 + dpRightToLeft[prev];
                }
        }


        int ans=1;
        for(int i=0;i<n;i++)
            ans=Math.max(ans,dpLeftToRight[i]+dpRightToLeft[i]-1);

        return ans;
    }


}
