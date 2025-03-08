package Trees.practice;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        MinInTree minInTree = new MinInTree();

        Node node = new Node(22);

        Node node1 = new Node(14);
        Node node2 = new Node(30);

        Node node3 = new Node(12);
        Node node4 = new Node(24);

        Node node5 = new Node(10);
        Node node6 = new Node(20);

        Node node7 = new Node(18);
        Node node8 = new Node(80);

        minInTree.root = node;
        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.right = node8;

        System.out.println("Min Value : " + minInTree.findMin(minInTree.root));

        System.out.println("Max Value : " + minInTree.findMax(minInTree.root));

        System.out.println("Non-Recursive Element Exist : " + minInTree.seacrhInTreeNonRecursive(minInTree.root, 112));

        System.out.println("Size of Tree : " + minInTree.sizeOfTree(minInTree.root));

        System.out.println("Height of Tree : " + minInTree.heightOfTree(minInTree.root));

        System.out.println("Height of Tree Without Recursion: " + minInTree.heightOfTreeWithoutRecursion(minInTree.root));

        System.out.println("Deepest Node of Tree : " + minInTree.deepestNodeOfTree(minInTree.root));

        int diamater =0;
        diamater=minInTree.diaMeterOfTree(minInTree.root,diamater);
        System.out.println("Diameter of Tree : " + diamater);



    }
}

class MinInTree {
    Node root;

    public MinInTree() {
        this.root = null;
    }

    public int findMin(Node root) {
        int root_val, left, right, min = Integer.MAX_VALUE;

        if (root != null) {
            root_val = root.val;
            left = findMin(root.left);
            right = findMin(root.right);
            min = Math.min(root_val, Math.min(left, right));
        }
        return min;
    }

    public int findMax(Node root) {
        int left, right, root_val, max = Integer.MIN_VALUE;
        if (root != null) {
            root_val = root.val;
            left = findMax(root.left);
            right = findMax(root.right);

            max = Math.max(root_val, Math.max(left, right));
        }
        return max;
    }

    public boolean seacrhInTreeNonRecursive(Node root, int valueToSeacrh) {
        if (root == null) return false;

        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.val == valueToSeacrh) return true;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }

    public int sizeOfTree(Node root) {
        if (root == null) return 0;

        return sizeOfTree(root.left) + 1 + sizeOfTree(root.right);
    }

    public int heightOfTree(Node root) {
        if (root == null) return 0;

        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    public int heightOfTreeWithoutRecursion(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        int level = 0;

        if (root == null)
            return 0;

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                level++;
            } else {
                if (root.left != null) {
                    queue.add(root.left);
                }

                if (root.right != null) {
                    queue.add(root.right);
                }
            }
        }

        return level;
    }

    public int deepestNodeOfTree(Node root) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return temp.val;
    }

    public int diaMeterOfTree(Node root,int diameter) {

        if(root==null)
            return 0;

        int left = diaMeterOfTree(root.left,diameter);
        int right = diaMeterOfTree(root.right,diameter);

        diameter = Math.max(diameter,left+right);

        return Math.max(left,right)+1;

    }
}

class Node {
    public Node left;
    public Node right;
    public int val;

    Node(int val) {
        this.val = val;
    }
}

