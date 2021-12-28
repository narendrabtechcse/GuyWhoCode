package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLB {
    BinaryNodeLB root;

    public BinaryTreeLB() {
        this.root = null;
    }


    //preorder Traversal of binary tree
    public void inOrderTraversal(BinaryNodeLB node){
        if(node==null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    public void preOrderTraversal(BinaryNodeLB node) {
        if(node==null)
            return;
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal(BinaryNodeLB node) {
        if(node==null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value+ " ");
    }

    public void levelOrder(BinaryNodeLB nodeLB) {

        if (nodeLB==null)
            return;

        Queue<BinaryNodeLB> queue = new LinkedList<>();

        queue.add(nodeLB);

        while(!queue.isEmpty())
        {
            BinaryNodeLB temp = queue.remove();

            System.out.print(temp.value + " ");
            if(temp.left!=null)
            queue.add(temp.left);
            if(temp.right!=null)
            queue.add(temp.right);
        }
    }

    public void insertInTree(String value)
    {
        BinaryNodeLB nodeLB = new BinaryNodeLB();
        nodeLB.value = value;

        if(root==null) {
            root = nodeLB;
        System.out.print("Inserted New node into the root of the tree !!");
        return;
        }else{
            Queue<BinaryNodeLB> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty())
            {
                BinaryNodeLB temp = queue.remove();

                if(temp.left==null) {
                    temp.left = nodeLB;
                    System.out.println("Inserted new node at left");
                    break;
                }
                else if(temp.right==null) {
                    temp.right = nodeLB;
                    System.out.println("Inserted new node at right");
                    break;
                }
                else {
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }
        }


    }
}
