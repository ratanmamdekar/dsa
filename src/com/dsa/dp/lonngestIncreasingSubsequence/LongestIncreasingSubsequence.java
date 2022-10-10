package com.dsa.dp.lonngestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,100,18};

        System.out.println(lengthOfLISMemo(nums));
        System.out.println(lengthOfLISTabu(nums));
        System.out.println(printLIS(nums));
        System.out.println(lengthOfLISBinarySearch(nums));
    }

    //cannot be used to find the LIS, only gives length, since we update the list to get max size()
    private static int lengthOfLISBinarySearch(int[] nums) {
        List<Integer> longestList = new ArrayList<>();

        for(int num: nums){
            if(longestList.size()==0|| longestList.get(longestList.size()-1)<num)
                longestList.add(num);
            else
                longestList.set(getIndex(longestList,num),num);
        }

        return longestList.size();
    }

    private static int getIndex(List<Integer> longestList, int num) {
        int low =0, high = longestList.size()-1;
        int idx=0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(longestList.get(mid).equals(num))
                return mid;
            else if(longestList.get(mid) > num){
                idx=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return idx;
    }

    private static List<Integer> printLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n],hash = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);
        int maxi=1;
        int lastInd = 0;
        for(int ind=0;ind<n;ind++){
            for (int prev =0;prev<ind;prev++)
                if(nums[prev]<nums[ind] && dp[ind]<1+dp[prev]){
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

    private static int lengthOfLISTabu(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];


        for(int i = nums.length-1;i>=0;i--)
            for (int prev = i-1;prev>=-1;prev--){
                int take=0,notTake=0;

                notTake = dp[i+1][prev+1];

                if(prev==-1 || nums[prev]<nums[i]){
                    take = 1 + dp[i+1][i+1];
                }


                dp[i][prev+1] = Math.max(notTake,take);
            }
        return dp[0][0];
    }

    public static int lengthOfLISMemo(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int [] row:dp)
            Arrays.fill(row,-1);
        return helper(0,nums.length,nums,-1,dp);
    }


    private static int helper(int i, int n, int[] nums, int prev,int[][] dp) {
        if(i==n)
            return 0;
        else{
            if(dp[i][prev+1]!=-1)
                return dp[i][prev+1];
            int take=0,notTake=0;
            if(prev==-1 || nums[prev]<nums[i]){
                take = 1 + helper(i+1,n,nums,i,dp);
            }
            notTake = helper(i+1,n,nums,prev,dp);

            return dp[i][prev+1] = Math.max(notTake,take);

        }

    }


}
