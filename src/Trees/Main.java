package Trees;

public class Main {

    public static void main(String[] args) {

        BinaryTreeLB binaryTree = new BinaryTreeLB();

        BinaryNodeLB N1 = new BinaryNodeLB();
        N1.value = "N1";

        BinaryNodeLB N2 = new BinaryNodeLB();
        N2.value = "N2";

        BinaryNodeLB N3 = new BinaryNodeLB();
        N3.value = "N3";

        BinaryNodeLB N4 = new BinaryNodeLB();
        N4.value = "N4";

        BinaryNodeLB N5 = new BinaryNodeLB();
        N5.value = "N5";

        BinaryNodeLB N6 = new BinaryNodeLB();
        N6.value = "N6";

        BinaryNodeLB N7 = new BinaryNodeLB();
        N7.value = "N7";

        BinaryNodeLB N8 = new BinaryNodeLB();
        N8.value = "N8";

        BinaryNodeLB N9 = new BinaryNodeLB();
        N9.value = "N9";

        binaryTree.root = N1;

        N1.left = N2;
        N1.right = N3;

        N2.left = N4;
        N2.right = N5;

        N3.left = N6;
        N3.right = N7;

        N4.left = N8;
        N4.right = N9;

        //trees level order traversal
        //level order traversal
        System.out.println("Level Order Traversal of the tree is : ");
        binaryTree.levelOrder(binaryTree.root);

        System.out.println();

        //trees inorder traversal
        System.out.println("InOrder Traversal of the tree is : ");
        binaryTree.inOrderTraversal(binaryTree.root);

        System.out.println();

        //trees preorder traversal
        System.out.println("PreOrder Traversal of the tree is : ");
        binaryTree.preOrderTraversal(binaryTree.root);

        System.out.println();

        //trees postorder traversal
        System.out.println("PostOrder Traversal of the tree is : ");
        binaryTree.postOrderTraversal(binaryTree.root);


        binaryTree.insertInTree("N10");

        binaryTree.insertInTree("N11");
        binaryTree.insertInTree("N12");
        binaryTree.insertInTree("N13");
        binaryTree.insertInTree("N14");
        binaryTree.insertInTree("N15");
        binaryTree.insertInTree("N16");


        System.out.println("Level Order Traversal of the tree is : ");
        binaryTree.levelOrder(binaryTree.root);






    }
}