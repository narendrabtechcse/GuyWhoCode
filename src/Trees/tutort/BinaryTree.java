package Trees.tutort;

import Trees.BinaryNodeLB;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    BinaryTreeNode root;


    public BinaryTree() {
        this.root = null;
    }

    //inorder Traversal of binary tree
    public void inOrderTraversal(BinaryTreeNode node) {
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.data + " ----> ");
        inOrderTraversal(node.right);
    }

    //preorder Traversal of binary tree
    public void preOrderTraversal(BinaryTreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ----> ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }


    //postorder Traversal of binary tree
    public void postOrderTraversal(BinaryTreeNode node) {
        if (node == null)
            return;
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        System.out.print(node.data + " ----> ");
    }


    public void levelOrderTraversal(BinaryTreeNode node) {
        if (node == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryTreeNode element = queue.poll();
            System.out.print("---->" + element.data);
            if (element.left != null)
                queue.add(element.left);
            if (element.right != null)
                queue.add(element.right);
        }
    }

    public BinaryTreeNode deepestNodeOfTree(BinaryTreeNode node) {
        if(node==null)
            return null;
        
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);
        BinaryTreeNode element = null;
        
        while (!queue.isEmpty())
        {
            element = queue.poll();
            
            if(element.left!=null)
                queue.add(element.left);
            if(element.right!=null)
                queue.add(element.right);
        }
        System.out.println("The deepest node is : "+ element.data);
        return element;
    }

    //insert in Btree
    public void insertInTree(String value) {
        BinaryTreeNode node = new BinaryTreeNode();
        node.data = value;

        if (root == null) {
            root = node;
            System.out.print("Inserted New node into the root of the tree !! - " + value);
        } else {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                BinaryTreeNode temp = queue.remove();
                if (temp.left == null) {
                    temp.left = node;
                    System.out.println("Inserted new node at left : " + value);
                    break;
                } else if (temp.right == null) {
                    temp.right = node;
                    System.out.println("Inserted new node at right : " + value);
                    break;
                } else {
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }
        }
    }

    public void deleteDeepestNodeOfTree(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode presentNode = null, previousNode = null;

        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.poll();

            if (presentNode.left == null) {
                System.out.println(previousNode.right.data + " is deleted ");
                previousNode.right = null;
                break;
            } else if (presentNode.right == null) {
                System.out.println(presentNode.left.data + " is deleted ");
                presentNode.left = null;
                break;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    public void deleteNodeOfTree(String value) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode presentNode = queue.poll();
            if (presentNode.data.equals(value)) {
                presentNode.data = deepestNodeOfTree(root).data;
                deleteDeepestNodeOfTree(root);
                System.out.println("The Node has been deleted : " + value);
                return;
            } else {

                if (presentNode.left != null)
                    queue.add(presentNode.left);

                if (presentNode.right != null)
                    queue.add(presentNode.right);
            }
        }
    }

    public List<List<String>> zigZagTraversalOfTree(BinaryTreeNode root) {
        List<List<String>> result = new LinkedList<>();

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level=0;

        while(!queue.isEmpty())
        {
            Stack<String> stack = new Stack<>();
            List<String> list = new LinkedList<>();
            level++;
            int qSize = queue.size();
            for(int i=0;i<qSize;i++)
            {
                BinaryTreeNode presentNode = queue.poll();
                if(level%2==0)
                {
                    stack.add(presentNode.data);
                }else{
                    list.add(presentNode.data);
                }

                if(presentNode.left!=null)
                    queue.add((presentNode.left));
                if(presentNode.right!=null)
                    queue.add(presentNode.right);
            }

            while(!stack.isEmpty())
            {
                list.add(stack.pop());
            }
            result.add(list);
        }
        return result;
    }
}
