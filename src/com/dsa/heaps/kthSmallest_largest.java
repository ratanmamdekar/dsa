package com.dsa.heaps;

import java.util.*;

public class kthSmallest_largest {
    public static void main(String[] args) {
        int[] nums = {2, 4, 22, 13, 5, 42, 7, 12, 7, 18, 10};
        int k = 4;
        System.out.println("k = "+k);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        System.out.println("kthSmallest : " + maxHeap.poll());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        System.out.println("kthlargest : " + minHeap.poll());

        System.out.println("sorted array");
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num+",");
        }

    }
}
