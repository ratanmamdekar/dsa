package com.dsa.recursion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {
    public static void main(String[] args) {
        String[] arr1 = {"un","iq","ue"};  // 4 un+iq or iq+ue
        String[] arr2 = {"cha","r","act","ers"}; // 6 "chaers" ("cha" + "ers") and "acters" ("act" + "ers").

        System.out.println(maxLength(Arrays.asList(arr1)));
        System.out.println(maxLength(Arrays.stream(arr2).collect(Collectors.toList())));
    }

    static int maxLength(List<String> arr) {
        int n=arr.size();
        boolean[] contains = new boolean[26];
        boolean[][] arrMap = booleanHelper(arr,n);
        return helper(arr,n,0,contains,arrMap);
    }

    static int helper(List<String> arr, int n, int idx, boolean[]contains, boolean[][] arrMap){
        if(idx==n)
            return 0;

        int notPick = 0 + helper(arr,n,idx+1,contains,arrMap);
        int pick =0;
        if(validPick(contains,arrMap[idx])){
            for(int i=0;i<26;i++)
                if(arrMap[idx][i])
                    contains[i]=true;
            pick = arr.get(idx).length() + helper(arr,n,idx+1,contains,arrMap);

            for(int i=0;i<26;i++)
                if(arrMap[idx][i])
                    contains[i]=false;
        }

        return Math.max(pick,notPick);
    }

    static boolean validPick(boolean[]contains,boolean[] currMap){
        if(currMap[26])
            return false;
        for(int i=0;i<26;i++)
            if(contains[i] && currMap[i])
                return false;
        return true;
    }

    static boolean[][] booleanHelper(List<String> arr, int n){
        boolean[][] ans = new boolean[n][27];
        int i=0;
        for(String s:arr){
            for(char c:s.toCharArray()){
                if(ans[i][c-'a']) {
                    ans[i][26]=true;
                    continue;
                }
                ans[i][c-'a']=true;
            }
            i++;
        }
        return ans;
    }
}
