package Graphs.SSSP.SSSPPUsingBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphList {

    ArrayList<GraphNode> nodeList = new ArrayList<>();

    GraphList(ArrayList<GraphNode> nodes) {
        this.nodeList = nodes;
    }

    // For printing Graph to the console

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbours.size(); j++) {
                if (j == nodeList.get(i).neighbours.size() - 1) {
                    s.append((nodeList.get(i).neighbours.get(j).name));
                } else {
                    s.append((nodeList.get(i).neighbours.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void addUndirectedEdge(int i, int j) {

        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);

        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public void bfsTraversal(GraphNode startNode) {
        List<GraphNode> q = new LinkedList<>();

        System.out.println();
        System.out.println("BFS Traversal of the tree is : ");

        q.add(startNode);
        startNode.isVisited = true;

        while (!q.isEmpty()) {
            GraphNode currentNode = q.remove(0);
            currentNode.isVisited = true;

            System.out.print(currentNode.name + " ");

            for (GraphNode exec_node : currentNode.neighbours) {
                if (!exec_node.isVisited) {
                    q.add(exec_node);
                    exec_node.isVisited = true;
                }
            }
        }
    }

    public void DFS() {

        System.out.println("DFS Traversal of the tree is : ");

        for (GraphNode node : nodeList) {
            if (!node.isVisited)
                dfsTraversal(node);
        }

    }

    private void dfsTraversal(GraphNode node) {

        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        node.isVisited = true;

        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;

            System.out.print(currentNode.name + " ");

            for (GraphNode node_exec : currentNode.neighbours) {
                if (!node_exec.isVisited) {
                    stack.push(node_exec);
                    node_exec.isVisited = true;
                }

            }

        }

    }

    //printing the path in the graph
    public static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }

        System.out.print(node.name + " ");
    }


    public void BFSForSSSPP(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();

            currentNode.isVisited = true;

            System.out.println("Printting path for node " + currentNode.name + ": ");

            pathPrint(currentNode);
            System.out.println();
            for (GraphNode neighbour : currentNode.neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = currentNode;
                }
            }
        }
    }
}
