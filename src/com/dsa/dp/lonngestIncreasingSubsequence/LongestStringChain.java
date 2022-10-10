package com.dsa.dp.lonngestIncreasingSubsequence;

import java.util.Arrays;

public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};

        System.out.println(longestStringChain(words));
    }

    private static int longestStringChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp = new int[words.length];
        int ans =1;
        for(int idx=0;idx< words.length;idx++) {
            dp[idx]=1;
            for (int pre = 0; pre < idx; pre++)
                if (compareStrings(words[idx], words[pre]) && dp[idx] < 1 + dp[pre])
                    dp[idx] = 1 + dp[pre];
            ans = Math.max(ans,dp[idx]);
        }

        return ans;
    }

    private static boolean compareStrings(String s1, String s2) {
        int s1Len=s1.length(), s2Len = s2.length();
        if(s1Len!=s2Len+1)
            return false;

        int i=0,j=0;

        while (i<s1Len && j<s2Len)
        {
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else
                i++;
        }

        return j==s2Len;
    }
}
