package com.dsa.BinaryTree;

import java.util.*;

import static com.dsa.BinaryTree.BinaryTreeUtility.getBinaryTree;
import static com.dsa.BinaryTree.BinaryTreeUtility.TreeNode;

public class IterativeBinaryTreeTraversal {
    public static void main(String[] args) {
        TreeNode binaryTree = getBinaryTree();
        System.out.println(preorderTraversal(binaryTree));
        System.out.println(inorderTraversal(binaryTree));
        System.out.println(postorderTraversal(binaryTree));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();

        if(root==null)
            return ans;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);

            if(node.left!=null)
                stack.push(node.left);
            if(node.right!=null)
                stack.push(node.right);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;
        while(true){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }
            else{
                if(stack.isEmpty())
                    break;
                node=stack.pop();
                ans.add(node.val);
                node=node.right;
            }
        }


        return ans;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }

        return ans;
    }
}
