package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeGraph {
    /*
    0 - 3,2
    1 -
    2 - 1,4
    3 - 4
    4 -
 */
    public static List<List<Integer>> createAdjacencyList() {
        List<List<Integer>> g = new ArrayList<>();

        g.add(new ArrayList<>(Arrays.asList(3,2)));
        g.add(new ArrayList<>());
        g.add(new ArrayList<>(Arrays.asList(1,4)));
        g.add(new ArrayList<>(Arrays.asList(4)));
        g.add(new ArrayList<>());

        return g;
    }
}
