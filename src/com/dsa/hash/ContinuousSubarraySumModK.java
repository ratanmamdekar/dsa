package com.dsa.hash;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySumModK {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(checkSubarraySum(nums,k)); //true 2+4
    }

    static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0;

        for(int i=0;i<nums.length;++i){
            sum=(sum+nums[i])%k;
            if(sum==0 && i>0)
                return true;

            if(map.containsKey(sum)){
                if(i-map.get(sum)>1)
                    return true;
            }
            else
                map.put(sum,i);
        }

        return false;
    }
}
