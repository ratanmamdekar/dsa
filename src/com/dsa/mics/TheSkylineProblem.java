package com.dsa.mics;

import java.util.*;

public class TheSkylineProblem {
//    Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//    Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(getSkyline(buildings));
    }


    public static   class Triplet{
        int x,y;
        char c;

        Triplet(int x,int y,char c){
            this.x=x;
            this.y=y;
            this.c=c;
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Triplet> list = new ArrayList<>();
        for(int[] b :buildings){
            list.add(new Triplet(b[0],b[2],'s'));
            list.add(new Triplet(b[1],b[2],'e'));
        }
/*         for same side of building coinciding
                if start point then revesre order
                else increasing order
        for different side of building coinciding
                start side comes first
        otherwise sort by x
*/
        Collections.sort(list,(t1, t2)->{
            if(t1.x==t2.x && t1.c==t2.c){
                if(t1.c=='s')
                    return t2.y-t1.y;
                return t1.y-t2.y;
            }
            else if (t1.x==t2.x && t1.c!=t2.c){
                if(t1.c=='s')
                    return -1;
                else
                    return +1;
            }
            return t1.x-t2.x;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int max = 0;

        for(Triplet t :list){
            if(t.c=='s'){
                if(t.y>max){
                    max=t.y;
                    pq.add(t.y);
                    ans.add(new ArrayList<>(Arrays.asList(t.x,t.y)));
                }
                else
                    pq.add(t.y);
            }
            else{
                pq.remove(t.y);
                if(pq.peek()<max) {
                    ans.add(new ArrayList<>(Arrays.asList(t.x, pq.peek())));
                    max = pq.peek();
                }

            }
        }

        return ans;
    }
}
