package com.dsa.dp.partition;

import java.util.Arrays;

import static com.dsa.palindrome.PalindromeSubarray.precomputeSubarrayPaildrome;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//Return the minimum cuts needed for a palindrome partitioning of s.
public class PalindromePartitioning_II {
    public static void main(String[] args) {
        String s = "aab"; //1 (aa,b)
        System.out.println(minCutMemo(s));
        System.out.println(minCutTabu(s));
    }

    private static int minCutTabu(String s) {
        int[] dp = new int[s.length()+1];
        boolean[][] isP = precomputeSubarrayPaildrome(s);
        for(int idx=s.length()-1;idx>=0;idx--) {
            int ans = s.length();
            for (int i = idx; i < s.length(); i++) {
                if (isP[idx][i]) {  // precompute subbarray palindrome as using palindrome(l,r,s) is O(n) which is repeated
                    int temp = 1 + dp[i+1];//helper(s, i + 1, dp, isP);
                    ans = Math.min(ans, temp);
                }
            }
            dp[idx] = ans;

        }
        return dp[0] - 1;
    }

    static int minCutMemo(String s) {
        int[] dp = new int[s.length()];
        boolean[][] isP = precomputeSubarrayPaildrome(s);

        Arrays.fill(dp,-1);
        return helper(s,0,dp,isP)-1;
    }

    static int helper(String s, int idx,int[] dp,boolean[][] isP){
        if(idx==s.length())
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int ans = s.length();
        for(int i=idx;i<s.length();i++){
            if(isP[idx][i]){  // precompute subbarray palindrome as using palindrome(l,r,s) is O(n) which is repeated
                int temp = 1 + helper(s,i+1,dp,isP);
                ans = Math.min(ans,temp);
            }
        }
        return dp[idx]=ans;//==(int)1e9?0:ans;
    }

}
