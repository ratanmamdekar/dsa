package com.dsa.dp.grid;

public class PathsInMatrixWhoseSumIsDivisibleByK {
    public static int MOD = (int)1e9+7;

    public static void main(String[] args) {
        int[][] grid = {{5,2,4},{3,0,5},{0,7,2}}; //2 - [18(5,2,4,5,2) & 15(5,3,0,5,2)]
        int k = 3;
        System.out.println(numberOfPaths(grid,k));
    }

    static int numberOfPaths(int[][] grid, int k) {
        int dp[][][] = new int [grid.length][grid[0].length][k];

        dp[0][0][grid[0][0]%k]=1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i!=0){
                    for(int mod = 0;mod<k;mod++){
                        dp[i][j][mod] = (dp[i][j][mod]+dp[i-1][j][(100*k-grid[i][j]+mod)%k])%MOD;
                    }
                }

                if(j!=0){
                    for(int mod = 0;mod<k;mod++){
                        dp[i][j][mod] = (dp[i][j][mod]+dp[i][j-1][(100*k-grid[i][j]+mod)%k])%MOD;
                    }
                }
            }
        }

        return dp[grid.length-1][grid[0].length-1][0];
    }
}
