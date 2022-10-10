package com.dsa.dp.string;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1="abcde";
        String s2="abace";
        System.out.println(longestCommonSubsequenceMemo(s1,s2));
        System.out.println(longestCommonSubsequenceTabu(s1,s2));
    }

    public static int longestCommonSubsequenceTabu(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i1 = 1;i1<=s1.length();i1++)
            for (int i2 = 1;i2<=s2.length();i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1))
                    dp[i1][i2] =  1 + dp[i1-1][i2-1];
                else
                    dp[i1][i2] =  Math.max(dp[i1-1][i2],dp[i1][i2-1]);
            }
        printHelper(s1,s2,dp);
        return dp[s1.length()][s2.length()];
    }

    private static void printHelper(String s1, String s2, int[][] dp) {
        int len= dp[s1.length()][s2.length()];
//        for(int[] row : dp)
//            System.out.println(Arrays.toString(row));
        StringBuilder sb = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while (i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i-1][j] >=  dp[i][j-1])
                i--;
            else j--;
        }

        System.out.println(sb.reverse());
    }

    private static int longestCommonSubsequenceMemo(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int[] row : dp)
            Arrays.fill(row,-1);

        int ans = helperMemo(s1.length() , s2.length() , s1, s2, dp);
//        for (int[] row : dp)
//            System.out.println(Arrays.toString(row));
        printHelper(s1,s2,dp);
        return ans;
    }

    private static int helperMemo(int i1, int i2, String s1, String s2, int[][] dp) {
        if(i1==0 || i2==0)
            return 0;
        else {
            if(dp[i1][i2]!=-1)
                return dp[i1][i2];

            if(s1.charAt(i1-1)==s2.charAt(i2-1))
                return dp[i1][i2] =  1 + helperMemo(i1-1, i2-1, s1, s2, dp);
            else
                return dp[i1][i2] =  Math.max(helperMemo(i1-1, i2, s1, s2, dp),helperMemo(i1, i2-1, s1, s2, dp));


        }
    }
}
