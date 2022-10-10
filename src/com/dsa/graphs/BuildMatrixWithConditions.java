package com.dsa.graphs;

import java.util.*;

public class BuildMatrixWithConditions {
    public static void main(String[] args) {
        int k = 3;
        int[][] rowConditions = {{1,2},{3,2}}, colConditions = {{2,1},{3,2}};

        int[][] mat =  buildMatrixWithConditions(rowConditions,colConditions,k);
/*
        multiple answers are possible, one possible answer given below
        [0, 0, 1]   [3, 0, 0]
        [3, 0, 0]   [0, 0, 1]
        [0, 2, 0],  [0, 2, 0]
*/

        for(int[] row : mat)
            System.out.println(Arrays.toString(row));
    }

    private static int[][] buildMatrixWithConditions(int[][] rowConditions, int[][] colConditions,int n) {
        List<Integer> rowTopSort = kahnTopSort(rowConditions,n);
        List<Integer> colTopSort = kahnTopSort(colConditions,n);

        if(rowTopSort.size()<n || colTopSort.size()<n)
            return new int[0][0];

        System.out.println(rowTopSort);
        System.out.println(colTopSort);

        int[][] ans = new int[n][n];
        Map<Integer,Integer> colMap = new HashMap<>();

        for (int j=0;j<n;j++){
            colMap.put(colTopSort.get(j),j);
        }

        for (int i=0;i<n;i++)
            ans[i][colMap.get(rowTopSort.get(i))] = rowTopSort.get(i);

        return ans;
    }

    private static List<Integer> kahnTopSort(int[][] edges, int k) {
        List<Integer> topsort = new ArrayList<>();
        int[] inDegree = new int[k];

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<k;i++)
            graph.add(new ArrayList<>());

        for(int[] edge : edges) {
            inDegree[edge[1]-1]++;
            graph.get(edge[0]-1).add(edge[1]-1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<k;i++)
            if(inDegree[i]==0)
                queue.add(i);

        while (!queue.isEmpty()){
            int node = queue.poll();
            topsort.add(node+1);
            for(int nxt:graph.get(node)){
                inDegree[nxt]--;
                if(inDegree[nxt]==0)
                    queue.add(nxt);
            }

        }

        return topsort;
    }
}
