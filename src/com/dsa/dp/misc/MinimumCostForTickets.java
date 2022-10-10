package com.dsa.dp.misc;

public class MinimumCostForTickets {
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};

        System.out.println(mincostTicketsMemo(days,costs)); // 11
    }


    public static int mincostTicketsMemo(int[] days, int[] costs) {
        int[][] dp = new int[days.length][366];
        return helper(0,0,days,costs,dp);
    }

    public static int helper(int idx,int validTillDay,int[] days, int[] costs,int[][] dp){
        if(idx==days.length)
            return 0;
        if(validTillDay>=days[idx])
            return helper(idx+1,validTillDay,days,costs,dp);

        if(dp[idx][validTillDay]!=0)
            return dp[idx][validTillDay];

        int oneDay = costs[0] + helper(idx+1,days[idx],days,costs,dp);
        int oneWeek = costs[1] + helper(idx+1,days[idx]+6,days,costs,dp);
        int oneMonth = costs[2] + helper(idx+1,days[idx]+29,days,costs,dp);

        return dp[idx][validTillDay] = Math.min(oneDay,Math.min(oneWeek,oneMonth));
    }
}
