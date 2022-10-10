package com.dsa.graphs;

import java.util.*;

public class leftRightBottomView {

    static class Node{
        int val;
        Node left,right;

        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(2);
        root.right.left = new Node(3);

        List<List<Integer>> views = getLeftRightBottomView(root);

    }

    public static List<List<Integer>> getLeftRightBottomView(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        nodeQueue.add(root);
        levelQueue.add(0);
        List<Integer> leftView = new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();
        Map<Integer,Integer> verticalMap = new TreeMap<>();
        while(!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            for(int i=0;i<size;i++){
                Node node = nodeQueue.poll();
                int level = levelQueue.poll();
                if(i==0)
                    leftView.add(node.val);
                if(i==size-1)
                    rightView.add(node.val);

                verticalMap.put(level,node.val);

                if(node.left!=null) {
                    nodeQueue.add(node.left);
                    levelQueue.add(level-1);
                }
                if(node.right!=null) {
                    nodeQueue.add(node.right);
                    levelQueue.add(level+1);
                }
            }
        }

        System.out.println("LeftView : " +leftView);
        System.out.println("rightView : " +rightView);
        System.out.println("bottomView : " +verticalMap.values());

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(leftView);
        ans.add(rightView);
        ans.add(new ArrayList<>(verticalMap.values()));
        return ans;
    }
}
