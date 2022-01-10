package Trees.LeetCode;

import java.util.*;

public class pathsumlll {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int sum =1;
        Set<List<Integer>> result = new HashSet<>();
        public int pathSum(TreeNode root, int targetSum) {

            if(root==null)
                return 0;


            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode temp = queue.remove();

                hasPathSum(temp,targetSum,new ArrayList<>());


                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }

            return result.size();
        }

    /* public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null)
            return false;


            if( targetSum-root.val==0)
            return true;


        return (hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val));
    }*/

        public void hasPathSum(TreeNode root, int targetSum,List<Integer> list) {

            if(root == null)
                return ;

            list.add(root.val);

            if( targetSum-root.val==0){
                result.add(new LinkedList(list));
            }


            if(root.left!=null)
            {

                hasPathSum(root.left,targetSum-root.val,list) ;
            }

            if(root.right!=null)
            {

                hasPathSum(root.right,targetSum-root.val,list);
            }

            list.remove(list.size()-1);

        }



    }
}
