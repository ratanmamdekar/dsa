package com.dsa.slidingwindow.fixed;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNum {
    public static void main(String[] args) {
        int [] nums= {12,-1,9,-5,8,12,-15,23,60,41}; //-1,-1,-5,-5,-15,-15,-15,0,
        int k=3;
        int[] ans = new int[nums.length-k+1];
        int j=0,i=0;
        Queue<Integer> n = new LinkedList<>();
        while (j<nums.length){
            if(nums[j]<0)
                n.offer(j);

            if(j-i+1<k)
                j++;
            else {
                if(n.isEmpty())
                    ans[i]=0;
                else
                    ans[i]=nums[n.peek()];

                if (!n.isEmpty() && i >= n.peek())
                    n.poll();
                i++;
                j++;
            }
        }

        for(int num :ans)
            System.out.print(num+",");
    }
}
