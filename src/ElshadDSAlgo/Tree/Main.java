package ElshadDSAlgo.Tree;

public class Main {

	public static void main(String[] args) {

		BinaryTreeLL binaryTree = new BinaryTreeLL();
		
		BinaryNode N1 = new BinaryNode();
		N1.value = "N1";
		
		BinaryNode N2 = new BinaryNode();
		N2.value = "N2";
		
		BinaryNode N3 = new BinaryNode();
		N3.value = "N3";
		
		BinaryNode N4 = new BinaryNode();
		N4.value = "N4";
		
		BinaryNode N5 = new BinaryNode();
		N5.value = "N5";
		
		BinaryNode N6 = new BinaryNode();
		N6.value = "N6";
		
		BinaryNode N7 = new BinaryNode();
		N7.value = "N7";
		
		BinaryNode N8 = new BinaryNode();
		N8.value = "N8";
		
		BinaryNode N9 = new BinaryNode();
		N9.value = "N9";
		
		N1.left = N2;
		N1.right = N3;
		
		N2.left = N4;
		N2.right = N5;
		
		N3.left = N6;
		N3.right = N7;
		
		N4.left = N8;
		N4.right = N9;
		
		binaryTree.root = N1;
		
		//binaryTree.preOrder(binaryTree.root);
		
		//level order traversal
		binaryTree.levelOrder(binaryTree.root);
		
		binaryTree.insertInTree("N10");
		binaryTree.insertInTree("N11");
		binaryTree.insertInTree("N12");
		binaryTree.insertInTree("N13");
		binaryTree.insertInTree("N14");
		binaryTree.insertInTree("N15");
		binaryTree.insertInTree("N16");
		binaryTree.insertInTree("N17");
		binaryTree.insertInTree("N18");
		binaryTree.insertInTree("N19");
		binaryTree.insertInTree("N20");
		binaryTree.insertInTree("N21");
		
		binaryTree.searchInTree("N12");
		binaryTree.levelOrder(binaryTree.root);
		System.out.println(" ");
		System.out.println("Deepest Node in the Tree : "+binaryTree.getDeepestNode().value);
		
		binaryTree.deleteNode("N3");
		System.out.println();
		binaryTree.levelOrder(binaryTree.root);
	}
}
