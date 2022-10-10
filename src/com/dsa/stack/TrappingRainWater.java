package com.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        // ans 6;
        System.out.println(volume(heights));
    }

    private static int volume(int[] heights) {

        int[] largestOnLeft = largestOnLeft(heights);
        int[] largestOnRight = largestOnRight(heights);

        int ans=0;
        for(int i=0;i< heights.length;i++){
            ans+= Math.min(largestOnLeft[i],largestOnRight[i]) - heights[i];
        }
        return ans;
    }

    private static int[] largestOnRight(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i =n-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek()<=heights[i])
                stack.pop();

            res[i] = stack.isEmpty()?heights[i]:stack.peek();
            stack.offer(heights[i]);
        }


        return res;
    }

    private static int[] largestOnLeft(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i =0;i<n;i++){
            while (!stack.isEmpty() && stack.peek()<=heights[i])
                stack.pop();

            res[i] = stack.isEmpty()?heights[i]:stack.peek();
            stack.offer(heights[i]);
        }


        return res;
    }
}
