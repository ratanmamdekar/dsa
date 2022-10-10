package com.dsa.dp.string;

import java.util.Arrays;

public class MinimumInsertionsOrDeletionsToConvertS1ToS2 {
    public static void main(String[] args) {
        System.out.println(minDistance("eat","sea")); //2
    }

    public static int minDistance(String word1, String word2) {
        return word1.length()+word2.length() - 2* longestCommonSubsequenceMemo(word1,word2);
    }

    private static int longestCommonSubsequenceMemo(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int[] row : dp)
            Arrays.fill(row,-1);

        int ans = helperMemo(s1.length() , s2.length() , s1, s2, dp);

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
