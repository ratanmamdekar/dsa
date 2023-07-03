package com.dsa.recursion;

import java.util.HashSet;
import java.util.Set;

public class FindMinimumTimetoFinishAllJobs {
    public static void main(String[] args) {
        int[] jobs = {1,2,4,7,8};
        int k = 2;
        // 11(1+8+2, 4+7)
        System.out.println(minimumTimeRequired(jobs,k));
    }

    static int minimumTimeRequired(int[] jobs, int k) {
        int[] t = new int[k+1];
        t[k]=(int)1e9;
        helper(jobs,0,k,t);
        // System.out.println(Arrays.toString(t));
        return t[k];
    }

    static void helper(int[] jobs, int idx, int k, int[] t){
        if(idx==jobs.length){
            int max=0;
            for(int i=0;i<k;i++)
                max=Math.max(max,t[i]);
            t[k]=Math.min(max,t[k]);
            // System.out.println(Arrays.toString(t));

        }
        else{
            Set<Integer> seen = new HashSet<>();
            for(int i=0;i<k;i++){
                if(seen.contains(t[i]) || t[i]+jobs[idx]>t[k])
                    continue;
                seen.add(t[i]);
                t[i]+=jobs[idx];
                helper(jobs,idx+1,k,t);
                t[i]-=jobs[idx];
            }
        }
    }
}
