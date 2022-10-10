package com.dsa.dp.partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumCostToCutStick {
    public static void main(String[] args) {
        int stickLength=7;
        int[] cuts = {1,3,4,5};
        System.out.println(minCostModified(stickLength,cuts)); //  16
        System.out.println(minCostTabu(stickLength,cuts)); //  16
    }

    static int minCostTabu(int n, int[] cuts) {
        List<Integer> newCuts = Arrays.stream(cuts).sorted().boxed().collect(Collectors.toList());
        newCuts.add(n);
        newCuts.add(0,0);

        int[][] dp = new int[newCuts.size()][newCuts.size()];
        // return helperModified(newCuts,1,newCuts.size()-2,dp);

        for(int i=newCuts.size()-2;i>0;i--){
            for(int j=i;j<=newCuts.size()-2;j++){
                int ans = Integer.MAX_VALUE,temp;
                for(int k = i;k<=j;k++){
                    temp = newCuts.get(j+1)-newCuts.get(i-1) + dp[i][k-1]+ dp[k+1][j];
                    ans = Math.min(ans,temp);
                }
                dp[i][j]=ans;
            }
        }

        return dp[1][newCuts.size()-2];
    }

    static int minCostModified(int n, int[] cuts) {
        List<Integer> newCuts = Arrays.stream(cuts).sorted().boxed().collect(Collectors.toList());
        newCuts.add(n);
        newCuts.add(0,0);

        int[][] dp = new int[newCuts.size()][newCuts.size()];
        return helperModified(newCuts,1,newCuts.size()-2,dp);
    }

    private static int helperModified(List<Integer> newCuts, int ci, int cj, int[][] dp) {
        if(ci>cj)
            return 0;

        if(dp[ci][cj]!=0)
            return dp[ci][cj];

        int ans = Integer.MAX_VALUE,temp;
        for(int k = ci;k<=cj;k++){
            temp = newCuts.get(cj+1)-newCuts.get(ci-1) + helperModified(newCuts,ci,k-1,dp) + helperModified(newCuts,k+1,cj,dp);
            ans = Math.min(ans,temp);
        }

        return dp[ci][cj]=ans;
    }

    // carrying left and right can be omitted by using modified cuts array
    static int helper(int[] cuts, int ci, int cj, int l, int r,int[][] dp){

        if(ci>cj)
            return 0;

        if(dp[ci][cj]!=0)
            return dp[ci][cj];

        int ans = Integer.MAX_VALUE,temp;
        for(int k = ci;k<=cj;k++){
            temp = r-l + helper(cuts,ci,k-1,l,cuts[k],dp) + helper(cuts,k+1,cj,cuts[k],r,dp);
            ans = Math.min(ans,temp);
        }

        return dp[ci][cj]=ans;
    }
}
