package com.dsa.dp.grid;

import java.util.Arrays;

public class CherryPickupII {
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};  // ans = 24

        System.out.println(cherryPickupMemo(grid));
        System.out.println(cherryPickupTabu(grid));
    }

    private static int cherryPickupTabu(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][][] dp = new int[row][col][col];

        for(int j1 =0;j1<col;j1++)
            for(int j2 =0;j2<col;j2++){
                if(j1==j2)
                    dp[row-1][j1][j2] = grid[row-1][j1];
                else
                    dp[row-1][j1][j2] = grid[row-1][j1] + grid[row-1][j2];
            }

        for(int i = row-2;i>=0;i--)
            for(int j1 =0;j1<col;j1++)
                for(int j2 =0;j2<col;j2++){
                    int val = Integer.MIN_VALUE;
                    for(int x=-1;x<2;x++)
                        for(int y=-1;y<2;y++){
                            if(j1+x<0 || j1+x>=col || j2+y<0 || j2+y>=col)
                                continue;
                            if(j1==j2)
                                val = Math.max(val,grid[i][j1]+dp[i+1][j1+x][j2+y]);
                            else
                                val = Math.max(val,grid[i][j1]+grid[i][j2]+dp[i+1][j1+x][j2+y]);
                        }
                    dp[i][j1][j2]=val;
                }

        return dp[0][0][col-1];
    }

    public static int cherryPickupMemo(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][][] dp = new int[row][col][col];
        for(int[][] mat : dp)
            for(int[] rows : mat)
                Arrays.fill(rows,-1);
        return helper(0,0,col-1,grid,dp);
    }

    public static int helper(int i,int j1,int j2,int[][] grid,int[][][] dp){
        if(j1<0 || j2<0 ||j1>= grid[0].length ||j2>= grid[0].length)
            return Integer.MIN_VALUE;
        if(i==grid.length-1){
            if(j1==j2)
                return grid[i][j1];
            else
                return grid[i][j1]+grid[i][j2];
        }
        else{
            if(dp[i][j1][j2]!=-1)
                return dp[i][j1][j2];
            int val = Integer.MIN_VALUE;
            for(int x=-1;x<2;x++)
                for(int y=-1;y<2;y++){
                    if(j1==j2)
                        val = Math.max(val,grid[i][j1]+helper(i+1,j1+x,j2+y,grid,dp));
                    else
                        val = Math.max(val,grid[i][j1]+grid[i][j2]+helper(i+1,j1+x,j2+y,grid,dp));
                }
            return dp[i][j1][j2]=val;
        }

    }
}
