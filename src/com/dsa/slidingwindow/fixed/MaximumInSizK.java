package com.dsa.slidingwindow.fixed;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumInSizK {
    public static void main(String[] args) {
        int [] nums= {12,-1,9,-5,8,13,-15,23,60,41};
        int k=3;
        int[] ans = new int[nums.length-k+1];
        int j=0,i=0;
        Deque<Integer> q = new ArrayDeque<>();
//        System.out.println(n.peek());
        while (j<nums.length){
            while (!q.isEmpty() && q.peekLast()<nums[j])
                q.pollLast();
            q.addLast(nums[j]);
            if(j-i+1<k)
                j++;
            else if(j-i+1==k) {
                ans[i]=q.peekFirst();

                if(nums[i]==q.peekFirst())
                    q.pollFirst();
                j++;
                i++;
            }
        }

        for(int num :ans)
            System.out.print(num+",");
    }
}
