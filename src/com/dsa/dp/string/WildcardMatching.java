package com.dsa.dp.string;

import java.util.Arrays;

public class WildcardMatching {
    public static void main(String[] args) {
        String s1="**ray",s2="rayray"; //match s1 with s2

        System.out.println(wildcardMatchingSimple(s1,s2));
        System.out.println(wildcardMatchingMemo(s1,s2));
        System.out.println(wildcardMatchingTabu(s1,s2));
    }

    private static boolean wildcardMatchingTabu(String s1, String s2) {
        boolean [][] dp = new boolean[s1.length()+1][s2.length()+1];

        dp[0][0]=true;
        int ind=1;
        while (ind<=s1.length() && s1.charAt(ind-1) == '*')
                dp[ind++][0]=true;

        for (int i =1;i<=s1.length();i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {
                    dp[i][j] =dp[i-1][j-1];

                }
                else if (s1.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i-1][j]||dp[i][j-1];
                }
                else
                dp[i][j] = false;
            }
        }

//        for(boolean[] row:dp)
//            System.out.println(Arrays.toString(row));
        return dp[s1.length()][s2.length()];
    }


    private static boolean wildcardMatchingMemo(String s1, String s2) {
        int [][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);

        return helperMemo(s1,s2,s1.length(),s2.length(),dp);
    }

    private static boolean helperMemo(String s1, String s2, int i, int j, int[][] dp) {
        if(i==0) {
            return j == 0;
        }

        if(j==0){
            for(int ind=1;ind<=i;ind++)
                if(s1.charAt(ind-1)!='*')
                    return false;
            return true;
        }

        if(dp[i][j]!=-1)
            return dp[i][j] ==1;

        if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
            boolean ans = helperMemo(s1, s2, i-1, j-1,dp);
            dp[i][j] =ans?1:0;
            return ans;
        }
        if (s1.charAt(i-1)=='*'){
            boolean ans = helperMemo(s1, s2, i-1, j,dp)|| helperMemo(s1, s2, i, j-1,dp);

            dp[i][j] = ans?1:0;
            return ans;
        }

        dp[i][j] = 0;
        return false;

    }

    private static boolean wildcardMatchingSimple(String s1, String s2) {

        return helperMemo(s1,s2,s1.length(),s2.length());
    }

    private static boolean helperMemo(String s1, String s2, int i, int j) {
        if(i==0) {
            return j == 0;
        }

        if(j==0){
            for(int ind=1;ind<=i;ind++)
                if(s1.charAt(ind-1)!='*')
                    return false;
            return true;
        }
        if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?')
            return helperMemo(s1, s2, i-1, j-1);

        if (s1.charAt(i-1)=='*'){
            return helperMemo(s1, s2, i - 1, j) || helperMemo(s1, s2, i, j - 1);
        }

        return false;

    }


}
