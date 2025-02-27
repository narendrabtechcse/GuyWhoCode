package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLB {
    BinaryNodeLB root;

    public BinaryTreeLB() {
        this.root = null;
    }

    //preorder Traversal of binary tree
    public void inOrderTraversal(BinaryNodeLB node) {
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    public void preOrderTraversal(BinaryNodeLB node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal(BinaryNodeLB node) {
        if (node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder(BinaryNodeLB nodeLB) {

        if (nodeLB == null)
            return;

        Queue<BinaryNodeLB> queue = new LinkedList<>();

        queue.add(nodeLB);

        while (!queue.isEmpty()) {
            BinaryNodeLB temp = queue.remove();

            System.out.print(temp.value + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    //Get Deepest node
    public BinaryNodeLB getDeepestNode(BinaryNodeLB nodeLB) {

        Queue<BinaryNodeLB> queue = new LinkedList<>();

        queue.add(nodeLB);

        BinaryNodeLB presentNode = null;

        while (!queue.isEmpty()) {

            presentNode = queue.remove();

            if (presentNode.left != null)
                queue.add(presentNode.left);

            if (presentNode.right != null)
                queue.add(presentNode.right);

        }

        return presentNode;
    }

    //delete deepest node in BT
    public void deleteDeepestNode(BinaryNodeLB nodeLb) {
        Queue<BinaryNodeLB> queue = new LinkedList<BinaryNodeLB>();
        queue.add(nodeLb);

        BinaryNodeLB presentNode = null, previousNode = null;

        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();

            if (presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                presentNode.left = null;
                return;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    public void deleteNode(String value) {
        Queue<BinaryNodeLB> queue = new LinkedList<>();
        queue.add(root);

        BinaryNodeLB presentNode = null;

        while (!queue.isEmpty()) {
            presentNode = queue.remove();

            System.out.println("presentNode.value : " +presentNode.value);

            if (presentNode.value.equals(value)) {
                presentNode.value = getDeepestNode(root).value;

                deleteDeepestNode(root);
                System.out.println("The Node has been deleted : " + value);
                return;
            } else {
                if (presentNode.left != null)
                    queue.add(presentNode.left);

                 if (presentNode.right != null)
                    queue.add(presentNode.right);
            }
        }

        System.out.println("Node not found in the tree !!");
    }

    //insert in Btree
    public void insertInTree(String value) {
        BinaryNodeLB nodeLB = new BinaryNodeLB();
        nodeLB.value = value;

        if (root == null) {
            root = nodeLB;
            System.out.print("Inserted New node into the root of the tree !!");
        } else {
            Queue<BinaryNodeLB> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                BinaryNodeLB temp = queue.remove();

                if (temp.left == null) {
                    temp.left = nodeLB;
                    System.out.println("Inserted new node at left");
                    break;
                } else if (temp.right == null) {
                    temp.right = nodeLB;
                    System.out.println("Inserted new node at right");
                    break;
                } else {
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }
        }
    }




    //zigzag traversal

    public List<List<String>> zigzagLevelOrder(BinaryNodeLB root) {

        List<List<String>> result = new LinkedList<>();

        Queue<BinaryNodeLB> queue = new LinkedList<>();
        queue.offer(root);

        if(root == null){
            return result;
        }

        int level = 0;

        while(!queue.isEmpty())
        {
            level++;

            int qSize = queue.size();

            Stack<String> stack = new Stack<String>();
            List<String> list = new LinkedList<>();

            for(int i=1;i<=qSize;i++) {

                BinaryNodeLB presentNode = queue.poll();

                if(level%2==1){
                    list.add(presentNode.value);
                }else{
                    stack.push(presentNode.value);
                }

                if (presentNode.left != null)
                    queue.offer(presentNode.left);
                if (presentNode.right != null)
                    queue.offer(presentNode.right);
            }

            while(!stack.isEmpty())
                list.add(stack.pop());

            result.add(list);
        }
        return result;
    }
}
