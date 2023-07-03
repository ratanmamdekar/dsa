package com.dsa.mics;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        System.out.println(increasingTriplet(nums));
    }

    static boolean increasingTriplet(int[] nums) {

        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for(int num: nums){
            if(num<=small)
                small=num;
            else if(num<=mid)
                mid=num;
            else
                return true;
        }

        return false;

//         int l = nums.length;
//         int[] smallestOnLeft = new int[l];
//         smallestOnLeft[0] = nums[0];
//         for(int i=1;i<l;i++)
//             smallestOnLeft[i] = Math.min(nums[i],smallestOnLeft[i-1]);

//         int[] largestOnRight = new int[l];
//         largestOnRight[l-1] = nums[l-1];
//         for(int i=l-2;i>=0;i--)
//             largestOnRight[i] = Math.max(nums[i],largestOnRight[i+1]);

//         for(int i=0;i<l;i++){
//             if(smallestOnLeft[i]<nums[i] && nums[i]<largestOnRight[i])
//                 return true;
//         }
//         return false;
    }
}
