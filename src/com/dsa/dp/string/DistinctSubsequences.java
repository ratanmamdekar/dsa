package com.dsa.dp.string;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        int[] a = new  int[2];
        int[] b = new  int[2];
        a[0]=1;a[1]=2;
        b=Arrays.copyOf(a,a.length);
        a[1]=1+b[1];
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        String s = "babgbag", t = "bag";
        System.out.println("Distinct subsequences of ("+s+","+t+")");
        System.out.println(numDistinctMemo(s,t)); //5
        System.out.println(numDistinctTabu(s,t)); //5
    }

    private static int numDistinctTabu(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

//        if(s.charAt(0)==t.charAt(0))
//            dp[0][0]=1;

        for(int i=0,j=0;i<=s.length();i++){
            dp[i][j]=1;
//            dp[i][j]=dp[i-1][j];
//            if(s.charAt(i)==t.charAt(j))
//                dp[i][j]++;
        }

        for(int i=1;i<=s.length();i++)
            for (int j=1;j<=t.length();j++){
                int take=0,notTake;
                notTake = dp[i-1][j];
                if(s.charAt(i-1)==t.charAt(j-1))
                    take = dp[i-1][j-1];

                dp[i][j] = take+notTake;
            }

//        for(int[] row:dp)
//            System.out.println(Arrays
//                    .toString(row));

        return dp[s.length()][t.length()];
    }

    public static int numDistinctMemo(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return helperMemo(s,t,s.length(),t.length(),dp);
    }

    public static int helperMemo(String s, String t, int i, int j,int[][] dp){
        if(j==0)
            return 1;
//        if(i==0){
//            return (j==0 && s.charAt(i)==t.charAt(j))?1:0;
//        }
        if(i==0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int notTake = helperMemo(s,t,i-1,j,dp);
        int take=0;
        if(s.charAt(i-1)==t.charAt(j-1))
            take = helperMemo(s,t,i-1,j-1,dp);

        return dp[i][j] = take+notTake;


    }
}
