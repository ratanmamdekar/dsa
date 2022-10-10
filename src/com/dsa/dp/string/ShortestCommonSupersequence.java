package com.dsa.dp.string;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String s1 = "groot";
        String s2 = "brute";
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        int ans = s1.length()+s2.length()-longestCommonSubsequenceTabu(s1,s2,dp);
        System.out.println("Length of SCS("+s1+","+s2+") = " + ans);

        printHelper(s1,s2,dp);

    }

    private static void printHelper(String s1, String s2, int[][] dp) {
        StringBuilder sb = new StringBuilder();
        int i=s1.length(),j=s2.length();

        while (i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>=dp[i][j-1]){
                sb.append(s1.charAt(i-1));
                i--;
            }
            else {
                sb.append(s2.charAt(j-1));
                j--;
            }
        }

        while (j>0)
            sb.append(s2.charAt(-1+j--));
        while (i>0)
            sb.append(s1.charAt(-1+i--));

        System.out.println(sb.reverse());
    }

    public static int longestCommonSubsequenceTabu(String s1, String s2, int[][] dp) {


        for (int i1 = 1;i1<=s1.length();i1++)
            for (int i2 = 1;i2<=s2.length();i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1))
                    dp[i1][i2] =  1 + dp[i1-1][i2-1];
                else
                    dp[i1][i2] =  Math.max(dp[i1-1][i2],dp[i1][i2-1]);
            }
        return dp[s1.length()][s2.length()];
    }
}
