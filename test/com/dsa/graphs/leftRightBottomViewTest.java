package com.dsa.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class leftRightBottomViewTest {

    @Test
    void testLeftView(){
        leftRightBottomView.Node root = new leftRightBottomView.Node(1);
        root.left = new leftRightBottomView.Node(4);
        root.right = new leftRightBottomView.Node(2);
        root.right.left = new leftRightBottomView.Node(3);

        List<List<Integer>> integers = leftRightBottomView.getLeftRightBottomView(root);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1,4,3));
        ans.add(Arrays.asList(1,2,3));
        ans.add(Arrays.asList(4,3,2));

        Assertions.assertIterableEquals(integers,ans);
    }
}