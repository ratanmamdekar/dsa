package com.dsa.math;

import java.util.Arrays;

public class FindTheOriginalArrayOfPrefixXor {
//    Input: pref = [5,2,0,3,1]
//    Output: [5,7,2,3,2]
    public static void main(String[] args) {
        int[] nums = {5,2,0,3,1};

        System.out.println(Arrays.toString(quadratic(Arrays.copyOf(nums,nums.length))));
        System.out.println(Arrays.toString(linear(Arrays.copyOf(nums,nums.length))));
    }

    private static int[] linear(int[] pref) {
        for(int i=pref.length-2;i>=0;i--)
            pref[i+1]^=pref[i];

        return pref;
    }

    private static int[] quadratic(int[] pref) {
        for(int i=0;i<pref.length;i++){
             for(int j=i+1;j<pref.length;j++)
                 pref[j]=pref[j]^pref[i];
         }

        return pref;
    }
}
