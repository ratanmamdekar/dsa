package com.dsa.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {

    public static void main(String[] args) {
        int n=5;
        int[] nums={6, 3, 7, 3, 6, 2,};
        System.out.println(Arrays.toString(nextGreater(nums, n)));
    }


    public static int[] nextGreater(int[] arr, int n) {
        //Write Your code here
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i])
                stack.pop();
            res[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }
}
