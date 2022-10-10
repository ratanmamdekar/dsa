package com.dsa.dp.partition;

import java.util.Arrays;

public class BooleanEvaluation {
    public static void main(String[] args) {

        System.out.println(evaluateExpMemo("T&T"));
        System.out.println(evaluateExpMemo("T^T^F"));
        System.out.println(evaluateExpMemo("F|T^F"));
        System.out.println(evaluateExpTabu("F|T^F"));
        System.out.println(evaluateExpMemo("F|T&F|T"));
        System.out.println(evaluateExpTabu("F|T&F|T"));
/*
[0 , -1,  1, -1,  0, -1,  3]
[-1, -1, -1, -1, -1, -1, -1]
[-1, -1,  1, -1,  0, -1,  2]
[-1, -1, -1, -1, -1, -1, -1]
[-1, -1, -1, -1,  0, -1,  1]
[-1, -1, -1, -1, -1, -1, -1]
[-1, -1, -1, -1, -1, -1,  1]
        */
    }

    private static int evaluateExpTabu(String exp) {
        int[][][] dp = new int[exp.length()][exp.length()][2];

        for(int i=0;i<exp.length();i++){
            dp[i][i][1]=(exp.charAt(i) == 'T')?1:0;
            dp[i][i][0]=(exp.charAt(i) == 'T')?0:1;
        }

        for (int i=exp.length()-1;i>=0;i-=2){
            for(int j=i+2;j<exp.length();j+=2){
                for(int needTrue=0;needTrue<2;needTrue++){
                    int count = 0;
                    for (int k = i + 1; k < j; k = k + 2) {
                        char c = exp.charAt(k);
                        int leftTrue = dp[i][k-1][1];//helper(exp, i, k - 1,dp,1);
                        int leftFalse = dp[i][k-1][0];//helper(exp, i, k - 1,dp,0);
                        int rightTrue = dp[k+1][j][1];//helper(exp, k + 1, j,dp,1);
                        int rightFalse = dp[k+1][j][0];//helper(exp, k + 1, j,dp,0);
                        if (c == '|') {
                            if(needTrue==1)
                                count= modAdd(count, modMultiply(leftTrue,rightTrue) ,
                                        modMultiply(leftFalse,rightTrue) , modMultiply(leftTrue,rightFalse));
                            else
                                count= modAdd(count, modMultiply(leftFalse,rightFalse));
                        }
                        else if (c == '&') {
                            if(needTrue==1)
                                count= modAdd(count, modMultiply(leftTrue,rightTrue)) ;
                            else
                                count= modAdd(count, modMultiply(leftFalse,rightFalse) ,
                                        modMultiply(leftFalse,rightTrue) , modMultiply(leftTrue,rightFalse));
                        }
                        else if (c == '^') {
                            if(needTrue==1)
                                count= modAdd(count, modMultiply(leftFalse,rightTrue) , modMultiply(leftTrue,rightFalse));
                            else
                                count= modAdd(count, modMultiply(leftTrue,rightTrue) , modMultiply(leftFalse,rightFalse));
                        }
                    }
                    dp[i][j][needTrue]=count;
                }
            }
        }

        return dp[0][exp.length()-1][1];
    }

    static int PRIME_MOD = (int)1e9+7;
    public static int evaluateExpMemo(String exp) {
        int[][][] dp = new int[exp.length()][exp.length()][2];
        for(int[][] mat:dp)
            for(int[] row :mat)
                Arrays.fill(row,-1);

        int countOfTrue = helper(exp, 0, exp.length() - 1, dp,1);
        return countOfTrue;
    }

    public static int helper(String exp,int i,int j,int[][][] dp,int needTrue) {
        if (i == j) {
            int count;
            if(needTrue==1)
                count = (exp.charAt(i) == 'T')?1:0;
            else
                count = (exp.charAt(i) == 'T')?0:1;
            return dp[i][j][needTrue]=count;
        }
        if(dp[i][j][needTrue]!=-1)
            return dp[i][j][needTrue];

        int count = 0;
        for (int k = i + 1; k < j; k = k + 2) {
            char c = exp.charAt(k);
            int leftTrue = helper(exp, i, k - 1,dp,1);
            int leftFalse = helper(exp, i, k - 1,dp,0);
            int rightTrue = helper(exp, k + 1, j,dp,1);
            int rightFalse = helper(exp, k + 1, j,dp,0);
            if (c == '|') {
                if(needTrue==1)
                    count= modAdd(count, modMultiply(leftTrue,rightTrue) ,
                            modMultiply(leftFalse,rightTrue) , modMultiply(leftTrue,rightFalse));
                else
                    count= modAdd(count, modMultiply(leftFalse,rightFalse));
            }
            else if (c == '&') {
                if(needTrue==1)
                    count= modAdd(count, modMultiply(leftTrue,rightTrue)) ;
                else
                    count= modAdd(count, modMultiply(leftFalse,rightFalse) ,
                            modMultiply(leftFalse,rightTrue) , modMultiply(leftTrue,rightFalse));
            }
            else if (c == '^') {
                if(needTrue==1)
                    count= modAdd(count, modMultiply(leftFalse,rightTrue) , modMultiply(leftTrue,rightFalse));
                else
                    count= modAdd(count, modMultiply(leftTrue,rightTrue) , modMultiply(leftFalse,rightFalse));
            }
        }
        return dp[i][j][needTrue]=count;
    }

    private static int modMultiply(int leftTrue, int rightTrue) {
        return (int) (((long) leftTrue% PRIME_MOD * rightTrue% PRIME_MOD)% PRIME_MOD);
    }
    private static int modAdd(int... nums){
        int ans =0;
        for(int num :nums)
            ans = (ans+num)% PRIME_MOD;
        return ans;
    }
}
