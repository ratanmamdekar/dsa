package com.dsa.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class frequencySort {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 3, 3, 3, 5 , 1, 4, 2};
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num:nums)
            freq.merge(num,1,(v1,v2)->v1+v2);


        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b)->b[0]-a[0]);

        for (int key : freq.keySet()) {
            maxHeap.offer(new int[]{freq.get(key),key});
        }

        System.out.println("Frequency sorted");
        while (!maxHeap.isEmpty()){
            int [] min = maxHeap.poll();
            for (int i=0;i<min[0];i++)
                System.out.print(min[1]+",");
        }
    }
}
