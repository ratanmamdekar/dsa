package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUtility {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


      public static TreeNode getBinaryTree(){
          TreeNode root = new TreeNode(5);
          root.left = new TreeNode(4);
          root.left.left = new TreeNode(11);
          root.left.left.left = new TreeNode(7);
          root.left.left.right = new TreeNode(2);

          root.right = new TreeNode(8);
          root.right.left = new TreeNode(13);
          root.right.right = new TreeNode(4);
          root.right.right.left = new TreeNode(5);
          root.right.right.right = new TreeNode(1);

          return root;
      }

      public static void printBinaryTree(TreeNode root){
          List<List<Integer>> tree = new ArrayList<>();
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);
          boolean allNull;
          while(!queue.isEmpty()){
              int size = queue.size();
              List<Integer> row = new ArrayList<>();
              allNull = true;
              for(int i=0;i<size;i++){
                  TreeNode node = queue.poll();
                  if(node==null){
                      row.add(null);
                      queue.add(null);
                      queue.add(null);
                  }
                  else {
                      allNull=false;
                      row.add(node.val);
                      queue.add(node.left);
                      queue.add(node.right);
                  }
              }
              if(allNull)
                  break;
              tree.add(row);
          }

          for (List<Integer> row : tree)
              System.out.println(row);
      }
  }