package Trees.tutort;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        BinaryTreeNode N1 = new BinaryTreeNode();
        N1.data = "N1";

        BinaryTreeNode N2 = new BinaryTreeNode();
        N2.data = "N2";

        BinaryTreeNode N3 = new BinaryTreeNode();
        N3.data = "N3";

        BinaryTreeNode N4 = new BinaryTreeNode();
        N4.data = "N4";

        BinaryTreeNode N5 = new BinaryTreeNode();
        N5.data = "N5";

        BinaryTreeNode N6 = new BinaryTreeNode();
        N6.data = "N6";

        BinaryTreeNode N7 = new BinaryTreeNode();
        N7.data = "N7";

        BinaryTreeNode N8 = new BinaryTreeNode();
        N8.data = "N8";

        BinaryTreeNode N9 = new BinaryTreeNode();
        N9.data = "N9";

        tree.root = N1;

        N1.left = N2;
        N1.right = N3;

        N2.left = N4;
        N2.right = N5;

        N3.left = N6;
        N3.right = N7;

        N4.left = N8;
        N4.right = N9;

        System.out.println("***********************************************************");
        System.out.println("InOrder Traversal of the Tree : ");
        tree.inOrderTraversal(N1);

        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("PreOrder Traversal of the Tree : ");
        tree.preOrderTraversal(N1);

        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("PostOrder Traversal of the Tree : ");
        tree.postOrderTraversal(N1);

        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("Level Traversal of the Tree : ");
        tree.levelOrderTraversal(N1);

        //Get Deepest node
        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("Deepest Node of the Tree : ");
        tree.deepestNodeOfTree(N1);

        //insert in Btree
        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("Insert Node of the Tree : ");
        tree.insertInTree("N10");

        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("Level Traversal of the Tree after Insertion is : ");
        tree.levelOrderTraversal(N1);

        //delete deepest node in BT
        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("Delete Deepest Node of the Tree  ");
        tree.deleteDeepestNodeOfTree(tree.root);

        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("Level Traversal of the Tree after Deletion of Deepest Node is ");
        tree.levelOrderTraversal(N1);

        //delete node in BT
        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("Delete Node of the Tree  ");
        tree.deleteNodeOfTree("N6");

        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("Level Traversal of the Tree after Deletion is ");
        tree.levelOrderTraversal(N1);


        //ZigZag Traversal of the BT
        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("Zigzag Traversal of the Tree  ");
        System.out.println(tree.zigZagTraversalOfTree(tree.root));

    }
}
