package com.dsa.mics;

import java.util.*;

public class Solution {


    private static long binaryExponentiationRecursive(long a, int b,int mod) {
        if(b==0)
            return 1;
        long res = binaryExponentiationRecursive(a,b/2,mod);
        if((b&1)==1)
            return ((a*(res*res)%mod)%mod);
        else
            return ((res*res)%mod) ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the number of test cases.
        int testCaseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= testCaseCount; caseIndex++) {
            int n = scanner.nextInt();

            int[] arr = new int[n];

            for(int i=0;i<n;i++){
                arr[i] = scanner.nextInt();
            }

//            for(int[] row:mxy)
//                System.out.println(Arrays.toString(row));
            int pairs = points(n,arr);
            System.out.println("Case #" + caseIndex + ": " + pairs);
        }
    }

    private static int points(int n, int[] arr) {
        int sum=0;
        for(int i=0;i<n;i++){
            int cur=0;
            for(int j=i;j<n;j++){
                cur+=arr[j];
                if(cur<0)
                    break;
                sum+=cur;
            }
        }

        return sum;
    }
}

