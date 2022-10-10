package com.dsa.dp.lonngestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};  //ans 3 - ([2,3] => [5,4] => [6,7])

        System.out.println(maxEnvelopes(envelopes));
        System.out.println(maxEnvelopesMemo(envelopes));
        System.out.println(maxEnvelopesTabu(envelopes));
        System.out.println(maxEnvelopesBinarySearch(envelopes));
    }

    private static int maxEnvelopesBinarySearch(int[][] envelopes) {
        List<Integer> longestList = new ArrayList<>();

        Arrays.sort(envelopes,(a, b)->{
            if(a[0]==b[0])
                return b[1]-a[1];
            return a[0]-b[0];
        });

        int[] nums = new int[envelopes.length];

        for(int idx =0;idx<envelopes.length;idx++)
            nums[idx] = envelopes[idx][1];

        return lengthOfLISBinarySearch(nums);
    }

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

    public static int maxEnvelopesTabu(int[][] envelopes) {
        Arrays.sort(envelopes,(a, b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });

        int[] dp = new int[envelopes.length];
        int ans=1;

        for(int idx=0;idx<envelopes.length;idx++){
            dp[idx]=1;
            for(int prev=0;prev<idx;prev++)
                if((envelopes[idx][0] > envelopes[prev][0] && envelopes[idx][1] > envelopes[prev][1]) && dp[idx]<1+dp[prev]){
                    dp[idx]=1+dp[prev];
                }
            ans=Math.max(ans,dp[idx]);
        }

        return ans;
    }

    private static int maxEnvelopesMemo(int[][] envelopes) {
        Arrays.sort(envelopes,(a, b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });

        int[][] dp = new int[envelopes.length][envelopes.length+1];
        for(int[] row :dp)
            Arrays.fill(row,-1);

        return helperMemo(0,-1,envelopes,dp);
    }

    private static int helperMemo(int idx, int prev, int[][] env, int[][] dp) {
        if(idx == env.length)
            return 0;

        if(dp[idx][prev+1]!=-1)
            return dp[idx][prev+1];

        int notTake,take=0;

        notTake = helperMemo(idx+1,prev,env,dp);

        if(prev==-1 || checkRussian(idx,prev,env))
            take = 1+helperMemo(idx+1,idx,env,dp);

        return dp[idx][prev+1] = Math.max(take,notTake);
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a, b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });


        return helper(0,-1,envelopes);

    }

    public static int helper(int idx,int prev,int[][] env){
        if(idx == env.length)
            return 0;

        int notTake,take=0;

        notTake = helper(idx+1,prev,env);

        if(prev==-1 || checkRussian(idx,prev,env))
            take = 1+helper(idx+1,idx,env);

        return Math.max(take,notTake);
    }


    public static boolean checkRussian(int idx,int prev,int[][] env){
        return env[idx][0] > env[prev][0] && env[idx][1] > env[prev][1];
    }
}
