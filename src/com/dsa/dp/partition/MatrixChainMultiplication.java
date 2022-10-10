package com.dsa.dp.partition;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[] = {10, 30, 5, 60};  // 4500

        int[][] dp = new int[arr.length][arr.length];
        System.out.println(simpleHelper(arr,1,arr.length-1));
        System.out.println(helperMemo(arr,1,arr.length-1,dp));
        System.out.println(helperTabu(arr));
    }

    private static int helperTabu(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int temp;
        for(int i = n-1;i>0;i--){
            for(int j=i+1;j<n;j++){
                int ans =Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    temp = arr[i-1]*arr[k]*arr[j] + dp[i][k]+ dp[k+1][j];

                    ans = Math.min(ans,temp);
                }
                dp[i][j] =ans;
            }
        }
        return dp[1][n-1];
    }

    private static int helperMemo(int[] arr, int i, int j, int[][] dp) {
        if(i==j)
            return 0;

        if(dp[i][j]!=0)
            return dp[i][j];

        int ans=Integer.MAX_VALUE,temp;

        for(int k=i;k<j;k++){
            temp = arr[i-1]*arr[k]*arr[j] + helperMemo(arr,i,k,dp) + helperMemo(arr,k+1,j,dp);

            ans = Math.min(ans,temp);
        }

        return dp[i][j]=ans;
    }

    static int simpleHelper(int[] arr, int i, int j){
        if(i==j)
            return 0;
        int ans=Integer.MAX_VALUE,temp;

        for(int k=i;k<j;k++){
            temp = arr[i-1]*arr[k]*arr[j] + simpleHelper(arr,i,k) + simpleHelper(arr,k+1,j);
            ans = Math.min(ans,temp);
        }
        return ans;
    }
}
