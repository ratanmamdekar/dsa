package com.dsa.BinaryTree;

import static com.dsa.BinaryTree.BinaryTreeUtility.getBinaryTree;
import static com.dsa.BinaryTree.BinaryTreeUtility.printBinaryTree;
import static com.dsa.BinaryTree.BinaryTreeUtility.TreeNode;

public class AddOneRowToTree {
    public static void main(String[] args) {
        TreeNode root = getBinaryTree();
        System.out.println("---------BEFORE---------");
        printBinaryTree(root);

        int val=2,depth=2;
        root = addOneRow(root,val,depth);
        System.out.println("---------AFTER---------");
        printBinaryTree(root);

    }
    static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            return new TreeNode(val,root,null);
        }
        helper(root,val,depth-2);
        return root;
    }

    static void helper(TreeNode root, int val, int depth) {
        if(root==null)
            return;
        if(depth==0){
            root.left = new TreeNode(val,root.left,null);
            root.right = new TreeNode(val,null,root.right);
            return ;
        }
        helper(root.left,val,depth-1);
        helper(root.right,val,depth-1);
    }
}
