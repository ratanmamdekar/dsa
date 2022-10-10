package com.dsa.dp.grid;

import java.util.Arrays;
import java.util.OptionalInt;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] points = {{20,50,10},{5,100,11}};
        int n= points.length;
        System.out.println(simpleNinjaTraining(n-1,points,3)); //exponential
        System.out.println(ninjaTrainingMemo(points)); //O(N*4*3)
        System.out.println(ninjaTrainingTabu(points)); //O(N*4*3)
    }

    private static OptionalInt ninjaTrainingTabu(int[][] points) {
        int n= points.length;
        int[][] dp = new int[n+1][4];
        for(int row =1;row<=n;row++){

            for (int i = 0; i < 3; i++) {
                int max=0;
                for (int j = 0;j < 3; j++){
                    if(i!=j)
                        max = Math.max(max,dp[row-1][j]);
                }
                dp[row][i]=points[row-1][i] + max;
            }
//            d[3] = Arrays.stream(d).max().getAsInt();
        }

        OptionalInt asInt = Arrays.stream(dp[n]).max();
        return asInt;
//        return dp[n][3];
    }

    private static int simpleNinjaTraining(int n, int[][] p,int last) {
        if(n<0)
            return 0;

         int t0=Integer.MIN_VALUE,t1=t0,t2=t0;
         if(last!=0) t0 = p[n][0] + simpleNinjaTraining(n-1,p,0);
         if(last!=1) t1 = p[n][1] + simpleNinjaTraining(n-1,p,1);
         if(last!=2) t2 = p[n][2] + simpleNinjaTraining(n-1,p,2);


        return Math.max(t0,Math.max(t1,t2));
    }

    public static int ninjaTrainingMemo(int points[][]) {

        int n= points.length;
        int[][] dp = new int[n][4];
        for(int[] dpRow:dp)
            Arrays.fill(dpRow,-1);
        return helperMemo(n-1,points,3,dp);
    }

    public static int helperMemo(int n,  int[][] p,int last,int[][] dp){
        if(n<0)
            return 0;
        if (dp[n][last]!=-1) return dp[n][last];
        int maxP=0;
        for(int i=0;i<=2;i++){
            if(i!=last)
                maxP = Math.max(maxP,p[n][i] + helperMemo(n-1,p,i,dp));
        }

        dp[n][last]= maxP;
        return dp[n][last];
    }
}
