package com.dsa.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestNumbers {
    public static void main(String[] args) {
        int[] nums = {2, 4, 22, 13, 5, 42, 7, 12, 7, 18, 10};
        int k = 4 , x=8;  // find k closest to x
        System.out.println("k = "+k+", x = "+x);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->-a[0]+b[0]);

        for (int num : nums) {
            maxHeap.offer(new int[]{Math.abs(num-x),num});
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

//        while (!maxHeap.isEmpty()){
//            int [] min = maxHeap.poll();
//            System.out.print(min[1]+",");
//        }
        for (int [] min : maxHeap){
            System.out.print(min[1]+",");
        }
        System.out.println("");
        System.out.println("sorted array");
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num+",");
        }
    }
}
