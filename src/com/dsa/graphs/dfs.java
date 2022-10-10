package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dsa.graphs.MakeGraph.createAdjacencyList;

public class dfs {
    public static void main(String[] args) {
        List<List<Integer>> g = createAdjacencyList();
        int n = g.size();
        boolean[] visited = new boolean[n];
        doDFS(g,visited,0);
    }

    private static void doDFS(List<List<Integer>> g,boolean[] visited,Integer node) {
        System.out.println("enter node "+node);
        visited[node]=true;

        for(Integer next : g.get(node)){
            if (!visited[next])
                doDFS(g,visited,next);
        }
        System.out.println("exit node "+node);

    }

}
