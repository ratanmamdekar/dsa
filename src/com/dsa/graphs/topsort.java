package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dsa.graphs.MakeGraph.createAdjacencyList;

public class topsort {
    public static void main(String[] args) {
        List<List<Integer>> g = createAdjacencyList();
        int n = g.size();
        boolean[] visited = new boolean[n];
        int[] topSort = new int[n];
        int index=n-1;
        for(int i =2;i<n+2;i++){
            if(!visited[i%n])
                index= doTopSort(g,visited,i%n,index,topSort);
        }
        System.out.println(Arrays.toString(topSort));
    }

    public static int doTopSort(List<List<Integer>> g, boolean[] visited, Integer node, int index, int[] topSort) {
        System.out.println("enter node "+node);
        visited[node]=true;

        for(Integer next : g.get(node)){
            if (!visited[next])
                index= doTopSort(g,visited,next,index,topSort);
        }
//        System.out.println("exit node "+node);
        topSort[index]=node;
        return index-1;
    }


}
