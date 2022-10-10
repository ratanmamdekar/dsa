package com.dsa.slidingwindow.fixed;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNum {
    public static void main(String[] args) {
        int [] nums= {12,-1,9,-5,8,12,-15,23,60,41};
        int k=3;
        int[] ans = new int[nums.length-k+1];
        int j=0;
        Queue<Integer> n = new LinkedList<>();
        System.out.println(n.peek());
        while (j<nums.length){
            if(nums[j]<0)
                n.offer(j);

            if(j+1>=k) {
                if(n.isEmpty())
                    ans[j+1-k]=0;
                else
                    ans[j+1-k]=nums[n.peek()];

                while (!n.isEmpty() && j+1-k >= n.peek())
                    n.poll();
            }
            j++;
        }

        for(int i :ans)
            System.out.print(i+",");
    }
}
