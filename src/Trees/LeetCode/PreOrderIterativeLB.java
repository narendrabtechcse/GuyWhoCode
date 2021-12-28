package Trees.LeetCode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode4 {
      int val;
      TreeNode4 left;
      TreeNode4 right;
      TreeNode4() {}
      TreeNode4(int val) { this.val = val; }
      TreeNode4(int val, TreeNode4 left, TreeNode4 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }


public class PreOrderIterativeLB {

        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<TreeNode>();

            if(root!=null)
                stack.push(root);

            TreeNode current;

            while(!stack.isEmpty())
            {

                current = stack.pop();

                list.add(current.val);

                if(current.right!=null)
                    stack.push(current.right);

                if(current.left!=null)
                    stack.push(current.left);
            }

            return list;

        }



}
