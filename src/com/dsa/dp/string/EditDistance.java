package com.dsa.dp.string;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1="horse",s2="ros";

        System.out.println(editDistanceMemo(s1,s2));
        System.out.println(editDistanceTabu(s1,s2));
    }

    private static int editDistanceTabu(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++)
            dp[i][0] = i;
        for(int j=0;j<=s2.length();j++)
            dp[0][j] = j;

        for(int i=1;i<=s1.length();i++)
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int replace = 1 + dp[i-1][j-1];
                    int delete = 1 + dp[i-1][j];
                    int insert = 1 + dp[i][j-1];

                    dp[i][j] = Math.min(Math.min(delete,insert),replace);
                }
            }
        return dp[s1.length()][s2.length()];
    }

    private static int editDistanceMemo(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return helper(s1,s2,s1.length(),s2.length(),dp);
    }

    private static int helper(String s1, String s2, int i, int j,int[][] dp) {
        if(j==0)
            return i;
        if(i==0)
            return j;

        if(dp[i][j] !=-1)
            return dp[i][j];

        int delete,insert,replace;

        if(s1.charAt(i-1)==s2.charAt(j-1))
            return dp[i][j] = helper(s1, s2, i-1, j-1,dp);

        replace = 1 + helper(s1, s2, i-1, j-1,dp);
        delete = 1 + helper(s1, s2, i-1, j,dp);
        insert = 1 + helper(s1, s2, i, j-1,dp);

        return dp[i][j] = Math.min(Math.min(delete,insert),replace);
    }


}
