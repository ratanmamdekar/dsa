package com.dsa.palindrome;

import com.dsa.dp.string.LongestCommonSubsequence;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";

        System.out.println(LongestCommonSubsequence.longestCommonSubsequenceTabu(s,new StringBuilder(s).reverse().toString()));
    }
}
