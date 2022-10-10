package com.dsa.dp.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        int[] nums = {4,5,2,1}, queries = {3,10,21}; //ans=[2,3,4]

//        int[] nums = {469781,45635,628818,324948,343772,713803,452081}, queries = {816646}; //ans=[3]

        System.out.println(Arrays.toString(answerQueries(nums,queries)));
    }
    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];

        for(int i=0;i<queries.length;i++)
            ans[i] = helper(nums,queries[i]);

        return ans;
    }

    public static int helper(int[] nums,int target){
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return help(0,nums,target,new ArrayList<>(),dp);
    }

    public static int help(int idx, int[] nums, int target, List<Integer> list, int[] dp){
        if(idx==nums.length){
            return list.size();
        }
//        if(dp[idx]!=-1)
//            return dp[idx];

        int notPick,pick= 0;


        notPick = help(idx+1,nums,target,list,dp);

        if(nums[idx]<=target){
            list.add(nums[idx]);
            pick = help(idx+1,nums,target-nums[idx],list,dp);
            list.remove(list.size()-1);
        }



        return dp[idx]=Math.max(pick,notPick);

    }
}
