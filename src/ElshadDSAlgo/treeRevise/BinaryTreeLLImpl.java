package ElshadDSAlgo.treeRevise;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLLImpl {
    public BinaryNode root;

    public BinaryTreeLLImpl()
    {
        this.root = null;
    }

    public void preOrder(BinaryNode node)
    {
        if(node==null)
            return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BinaryNode node)
    {
        if(node==null)
            return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(BinaryNode node)
    {
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder(BinaryNode node)
    {
        if(node==null)
            return;

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty())
        {
            BinaryNode presentNode = queue.remove();

            System.out.print(presentNode.value + " ");

            if(presentNode.left!=null)
                queue.add(presentNode.left);
            if(presentNode.right!=null)
                queue.add(presentNode.right);
        }
    }


}
