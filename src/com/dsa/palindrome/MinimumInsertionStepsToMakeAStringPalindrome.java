package com.dsa.palindrome;

import com.dsa.dp.string.LongestCommonSubsequence;

import java.util.Arrays;

public class MinimumInsertionStepsToMakeAStringPalindrome {
    public static void main(String[] args) {
        System.out.println(minInsertions("zzaazz")); // 0
        System.out.println(minInsertions("mbadm")); // 2  by mbdadbm or mdbabdm
        System.out.println(minInsertions("leetcode")); // 5 by leetcodocteel
        System.out.println(minInsertionsUsingLCS("leetcode")); // 5 by leetcodocteel
    }

    private static int minInsertionsUsingLCS(String s) {
        return  s.length() - LongestCommonSubsequence.longestCommonSubsequenceTabu(s,new StringBuilder(s).reverse().toString());
    }

    public static int minInsertions(String s) {

        int[][] dp = new int[s.length()][s.length()];
        for(int[] row:dp)
            Arrays.fill(row,-1);

        int helper = helper(s, 0, s.length() - 1, dp);
        return helper;
    }

    public static int helper(String s, int l,int r, int [][]dp){
        if(l>=r)
            return 0;
        if(dp[l][r]!=-1)
            return dp[l][r];

        if(s.charAt(l)==s.charAt(r))
            return dp[l][r] = helper(s,l+1,r-1,dp);

        return dp[l][r] = 1 + Math.min(helper(s,l+1,r,dp),helper(s,l,r-1,dp));
    }
}
