package ElshadDSAlgo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
	BinaryNode root;

	public BinaryTreeLL() {
		this.root=null;
	}
	
	//Preorder Traversal
	
	void preOrder(BinaryNode node) {
		if(node==null)
			return;
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	//InOrder Traversal
	
	void inOrder(BinaryNode node) {
		if(node==null)
			return;
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	
	//PostOrder Traversal
	
	void postOrder(BinaryNode node) {
		if(node==null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}
	
	
	void levelOrder(BinaryNode node) {
		if(node==null)
			return;
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			
			if(presentNode.left!=null)
				queue.add(presentNode.left);
			
			if(presentNode.right!=null)
				queue.add(presentNode.right);
			
		}
	}
	
	
	void searchInTree(String value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		System.out.println();

		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (value.equals(presentNode.value)) {
				System.out.println("Searched value is present in the tree : " + value);
				return;
			}

			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
		
		System.out.println("Searched value is NOT present in the tree : "+value);
	}
	
	// Insert Method
	
	void insertInTree(String value) {

		BinaryNode newNode = new BinaryNode();
		newNode.value = value;

		if (root == null) {
			root = newNode;
			System.out.println("Inserted new node at Root");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.left == null) {
				presentNode.left = newNode;
				System.out.println("Inserted new node at left");
				break;
			} else if (presentNode.right == null) {
				presentNode.right = newNode;
				System.out.println("Inserted new node at right");
				break;
			} else {
				queue.add(presentNode.left);
				queue.add(presentNode.right);
			}
		}

	}
	
	//Get Deepest node
	public BinaryNode getDeepestNode() {

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}

			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}

		}
		return presentNode;
	}

	
	//Delete Deepest node
	public void deleteDeepestNode() {
		
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		
		BinaryNode previousNode , presentNode = null;
		while(!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			
			if(presentNode.left==null) {
				previousNode.right = null;
				return;
			}
			else if(presentNode.right==null){
				presentNode.left = null;
				return;
			}
			
			queue.add(presentNode.left);
			queue.add(presentNode.right);
		}
		
	}
	
	//Delete Given node
	void deleteNode(String value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.println("presentNode.value : " +presentNode.value);
			if(presentNode.value == value) {
				presentNode.value = getDeepestNode().value;
				deleteDeepestNode();
				System.out.println("The node is Deleted !!");
				return;
			}else {
				if(presentNode.left!=null)
					queue.add(presentNode.left);
				if(presentNode.right!=null)
					queue.add(presentNode.right);
			}
		}
		
		System.out.println("Node not found in the tree !!");
	}
	
	
}
	
	


