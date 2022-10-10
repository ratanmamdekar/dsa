package com.dsa.heaps;

import java.util.PriorityQueue;

public class connectRopes {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        // add mins
        // 1,2,3,4 : 1+2=[3]
        // 3,3,4 : 3+3=[6]
        // 6,4 : 6+4=[10]
        // total = 3+6+10  = 19

        // add maxs
        // 1,2,3,4 : 3+4=[7]
        // 1,2,7: 7+2=[9]
        // 1,9 : 1+9=[10]
        // total = 7+9+10  = 26

        int ans=0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums)
            minHeap.offer(num);

        while (minHeap.size()>1){
            int m1 = minHeap.poll();
            int m2 = minHeap.poll();
            ans+=m1+m2;
            minHeap.offer(m1+m2);
        }
//        ans+=minHeap.poll();
        System.out.println(ans);

    }
}
