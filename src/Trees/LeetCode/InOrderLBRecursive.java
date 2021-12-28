package Trees.LeetCode;

/*

https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 */

import java.util.ArrayList;
import java.util.List;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InOrderLBRecursive {

    List<Integer> list = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root==null)
            return new ArrayList();

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);

        return list;

    }

}
