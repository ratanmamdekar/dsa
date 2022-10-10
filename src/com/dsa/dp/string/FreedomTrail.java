package com.dsa.dp.string;

import java.util.*;

public class FreedomTrail {
    public static void main(String[] args) {
        String ring = "godding", key = "gd"; // 1(press g) + 2(g to d) + 1(press d)
        System.out.println(findRotateSteps(ring,key));
    }

    public static int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<ring.length();i++){
            char c = ring.charAt(i);
            if(!map.containsKey(c))
                map.put(c,new ArrayList<>());
            map.get(c).add(i);
        }
        // System.out.println(map);
        int[][] dp = new int[ring.length()][key.length()];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return helper(map,0,key,0,ring.length(),dp);
    }

    static int helper(Map<Character,List<Integer>> map, int ri, String key, int ki,int rsize,int[][] dp){
        if(ki == key.length())
            return 0;
        if(dp[ri][ki]!=-1)
            return dp[ri][ki];
        char k = key.charAt(ki);
        int min=Integer.MAX_VALUE;
        for(int idx : map.get(k)){
            int d1 = Math.abs(ri-idx);
            int minDist = Math.min(d1,Math.abs(rsize-d1));
            // System.out.println(k+"+"+ri+"+"+idx+"+"+minDist);

            min = Math.min(min,1+minDist+helper(map,idx,key,ki+1,rsize,dp));
        }
        // System.out.println(k+"+"+ri+"+"+min);

        return  dp[ri][ki]=min;
    }
}
