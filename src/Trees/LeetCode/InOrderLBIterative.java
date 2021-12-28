package Trees.LeetCode;

/*

https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {
    }

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InOrderLBIterative {

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {

                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();

                list.add(current.val);

                current = current.right;
            }
        }
        return list;
    }
}
