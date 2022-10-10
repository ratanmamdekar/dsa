package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.List;

import static com.dsa.BinaryTree.BinaryTreeUtility.getBinaryTree;
import static com.dsa.BinaryTree.BinaryTreeUtility.TreeNode;

public class PathSum2 {
    public static void main(String[] args) {
        TreeNode binaryTree = getBinaryTree();
        List<List<Integer>> ans = new ArrayList<>();
        helper(binaryTree,22,ans,new ArrayList<>());
        System.out.println(ans);
    }

    public static void helper(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> path){
        if(root==null)
            return;
        targetSum-=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null && targetSum==0)
            ans.add(new ArrayList<>(path));

        helper(root.left,targetSum,ans,path);
        helper(root.right,targetSum,ans,path);


        targetSum+=root.val;
        path.remove(path.size()-1);
    }
}
