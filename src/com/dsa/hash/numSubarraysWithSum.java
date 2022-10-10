package com.dsa.hash;

import java.util.HashMap;
import java.util.Map;

public class numSubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        System.out.println(helper(nums,2));
    }

    private static int helper(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0,sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-goal))
                count+=map.get(sum-goal);

            map.merge(sum,1,(v1,v2)->v1+v2);
        }

        return count;
    }
}
