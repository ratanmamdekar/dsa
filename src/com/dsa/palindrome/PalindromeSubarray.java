package com.dsa.palindrome;

import java.util.Arrays;

public class PalindromeSubarray {
    public static void main(String[] args) {
        String str = "AAB";
        boolean[][] booleans = precomputeSubarrayPaildrome(str);
        for (boolean[] b:booleans)
            System.out.println(Arrays.toString(b));
    }

    public static boolean[][] precomputeSubarrayPaildrome(String s) {
        boolean[][] isP = new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--)
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || isP[i+1][j-1]))
                    isP[i][j]=true;
            }
        return isP;
    }
}
