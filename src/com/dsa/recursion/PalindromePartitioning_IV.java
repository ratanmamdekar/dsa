package com.dsa.recursion;

import static com.dsa.palindrome.PalindromeSubarray.precomputeSubarrayPaildrome;

public class PalindromePartitioning_IV {

//    Given a string s, return true if it is possible to split the string s into three non-empty palindromic substrings.
//    Otherwise, return false.
    public static void main(String[] args) {
        String s = "abcbdd"; // true (a,bcb,dd)
        System.out.println(checkPartitioning(s));
    }

    static boolean checkPartitioning(String s) {
        boolean[][] isP = precomputeSubarrayPaildrome(s);
        int required_cuts = 3 ;
        return helper(s,0,required_cuts,isP);

    }

    static boolean helper(String s, int i, int rem, boolean[][] isP){
        if(i==s.length())
            return false;
        if(rem==1)
            return isP[i][s.length()-1];

        for(int j=i;j<s.length();j++)
            if(isP[i][j] && helper(s,j+1,rem-1,isP))
                return true;

        return false;
    }
}
