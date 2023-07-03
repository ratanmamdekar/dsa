package com.dsa.dp.partition;

import java.util.Arrays;

// need to complete jobs in order
// need to complete at least one job per day
// difficulty of day is max of all jobs done on that day
public class MinimumDifficultyOfJobSchedule {
    public static void main(String[] args) {
//        int[] jobDifficulty = {6,5,4,3,2,1};  // (6,5,4,3,2),(1) : 6+1 =7
//        int d = 2;
        int[] jobDifficulty = {1,1,1,1};  // (6,5,4,3,2),(1) : 6+1 =7
        int d = 3;
        System.out.println(minDifficulty(jobDifficulty,d));
        System.out.println(minDifficultyMemo(jobDifficulty,d));
        System.out.println(minDifficultyTabu(jobDifficulty,d));
    }

    private static int minDifficultyTabu(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d)
            return -1;
        int[][] dp = new int[jobDifficulty.length+1][d+1];

        int max=0;
        for(int i= jobDifficulty.length-1;i>=0;i--){
            max = Math.max(max,jobDifficulty[i]);
            dp[i][1]=max;
        }
        for(int j=0;j<=d;j++)
            dp[jobDifficulty.length][j] = (int)1e9;

        for(int i= jobDifficulty.length-1;i>=0;i--){
            for(int j=2;j<=d;j++){
                max=-(int)1e9;
                int min=(int)1e9;
                for(int idx=i;idx<jobDifficulty.length;idx++){
                    max = Math.max(max,jobDifficulty[idx]);
                    int temp = max + dp[idx+1][j-1];
                    min = Math.min(min,temp);
                }

                dp[i][j]=min;
            }
        }
//        for(int[] row:dp)
//            System.out.println(Arrays.toString(row));
        return dp[0][d];
    }

    static int minDifficultyMemo(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d)
            return -1;
        int[][] dp = new int[jobDifficulty.length][d+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return helperMemo(jobDifficulty,0,d,dp);
    }

    static int helperMemo(int[] jobDifficulty,int i, int d,int[][] dp){

        if(i==jobDifficulty.length)
            return (int)1e9;
        if(dp[i][d]!=-1)
            return dp[i][d];
        if(d==1){
            int max=0;
            for(int idx=i;idx<jobDifficulty.length;idx++){
                max = Math.max(max,jobDifficulty[idx]);
            }
            return max;
        }

        int max=0;
        int min=(int)1e9;
        for(int idx=i;idx<jobDifficulty.length;idx++){
            max = Math.max(max,jobDifficulty[idx]);
            int temp = max + helperMemo(jobDifficulty,idx+1,d-1,dp);
            min = Math.min(min,temp);
        }

        return dp[i][d]=min;
    }

    static int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d)
            return -1;

        return SimpleHelper(jobDifficulty,0,d);
    }

    static int SimpleHelper(int[] jobDifficulty, int i, int d){

        if(i==jobDifficulty.length)
            return (int)1e9;

        if(d==1){
            int max=0;
            for(int idx=i;idx<jobDifficulty.length;idx++){
                max = Math.max(max,jobDifficulty[idx]);
            }
            return max;
        }

        int max=0;
        int min=(int)1e9;
        for(int idx=i;idx<jobDifficulty.length;idx++){
            max = Math.max(max,jobDifficulty[idx]);
            int temp = max + SimpleHelper(jobDifficulty,idx+1,d-1);
            min = Math.min(min,temp);
        }

        return min;
    }
}
