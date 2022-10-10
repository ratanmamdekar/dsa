package com.dsa.dp.array;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226"; //ans =3 (2,2,6 + 22,6 + 2,26)
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        int[]dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,0,dp);
    }

    private static int helper(String s,int idx,int[] dp){
        if(idx==s.length())
            return 1;

        if(dp[idx]!=-1)
            return dp[idx];

        if(s.charAt(idx)=='0')
            return dp[idx]=0;

        int oneC,twoC=0;
        oneC = helper(s,idx+1,dp);
        if(idx+2<=s.length()){
            int num = Integer.valueOf(s.substring(idx,idx+2));
            if(num>0 && num<27)
                twoC = helper(s,idx+2,dp);
        }

        return dp[idx]=oneC+twoC;
    }
}
