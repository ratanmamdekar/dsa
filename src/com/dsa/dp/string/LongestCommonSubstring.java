package com.dsa.dp.string;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1="abcde";
        String s2="abcace";

        System.out.println(longestCommonSubstringMemo(s1,s2));
    }

    private static int longestCommonSubstringMemo(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int ans = 0,end=0;
        for (int i1 = 1;i1<=s1.length();i1++)
            for (int i2 = 1;i2<=s2.length();i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1)) {
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                    if(ans<dp[i1][i2]){
                        ans=dp[i1][i2];
                        end = i1;
                    }
                }
                else
                    dp[i1][i2] =  0;
            }
//        printHelper(s1,ans,end);
        String s = s1.substring(end-ans,end);
        System.out.println(s);
        return ans;
    }
}
