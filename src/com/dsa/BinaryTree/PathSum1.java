package com.dsa.BinaryTree;

import static com.dsa.BinaryTree.BinaryTreeUtility.getBinaryTree;
import static com.dsa.BinaryTree.BinaryTreeUtility.TreeNode;

public class PathSum1 {
    public static void main(String[] args) {
        TreeNode binaryTree = getBinaryTree();
        System.out.println(hasPathSum(binaryTree,22));
    }


    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;

        targetSum-=root.val;
        if(root.left==null && root.right==null && targetSum==0)
            return true;

        if(hasPathSum(root.left,targetSum))
            return true;
        if(hasPathSum(root.right,targetSum))
            return true;

        targetSum+=root.val;
        return false;
    }
}
