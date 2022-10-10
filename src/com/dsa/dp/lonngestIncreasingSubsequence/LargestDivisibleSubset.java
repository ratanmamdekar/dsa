package com.dsa.dp.lonngestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {4,16,8,1,7};

        System.out.println(printLargestDivisibleSubset(nums));
    }


    private static List<Integer> printLargestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n],hash = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);
        int maxi=1;
        int lastInd = 0;
        for(int ind=0;ind<n;ind++){
            for (int prev =0;prev<ind;prev++)
                if(nums[ind]%nums[prev]==0 && dp[ind]<1+dp[prev]){
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                }
            if(maxi<dp[ind]){
                maxi = dp[ind];
                lastInd = ind;
            }
        }
        List<Integer> ans = new ArrayList<>();

        while (hash[lastInd]!=-1){
            ans.add(nums[lastInd]);
            lastInd = hash[lastInd];
        }
        ans.add(nums[lastInd]);
        //        System.out.println(Arrays.toString(dp));
        //        System.out.println(Arrays.toString(hash));
        Collections.reverse(ans);
        return ans;
    }
}
