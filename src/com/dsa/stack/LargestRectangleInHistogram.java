package com.dsa.stack;

import java.util.*;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
//        int[] nums = {2,1,5,6,2,3};
        int[] nums = {1,1,1};
        System.out.println(area(nums));
        System.out.println(areaSinglePass(nums));
    }

    private static int areaSinglePass(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea=0,area;
        for(int i =0;i<=nums.length;i++){
            while(!stack.isEmpty() && (i== nums.length || nums[stack.peek()]>=nums[i])) {
                int idx = stack.pop();
                int right = i;
                int left = stack.isEmpty()?-1:stack.peek();
                area = (right-left-1)*nums[idx];
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static int area(int[] nums){

        System.out.println(Arrays.toString(nums));
        int[] smallestOnLeft = smallestOnLeft(nums);
        System.out.println(Arrays.toString(smallestOnLeft));
        int[] smallestOnRight = smallestOnRight(nums);
        System.out.println(Arrays.toString(smallestOnRight));

        int area=0;
        for(int i=0;i<nums.length;i++){
            area = Math.max(area, nums[i]*(smallestOnRight[i]-smallestOnLeft[i]-1));
        }
        return area;
    }

    private static int[] smallestOnRight(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i =n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i])
                stack.pop();

            res[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }

        return res;
    }

    private static int[] smallestOnLeft(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i =0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i])
                stack.pop();

            res[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return res;
    }
}
