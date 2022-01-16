package Graphs.TraverseAllPaths.adjMatrix;

import java.util.ArrayList;
import java.util.Stack;

public class TraverseAllPaths {

    ArrayList<GraphNode> nodeList = new ArrayList<>();

    TraverseAllPaths(ArrayList<GraphNode> nodes)
    {
        this.nodeList = nodes;
    }

    // For printing Graph to the console

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j =0; j < nodeList.get(i).neighbours.size(); j++) {
                if (j == nodeList.get(i).neighbours.size()-1 ) {
                    s.append((nodeList.get(i).neighbours.get(j).name) );
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



    public void DFS() {

        System.out.println("DFS Traversal of the tree is : ");

        for (GraphNode node : nodeList) {
            if(!node.isVisited)
                dfsTraversal(node);
        }

    }

    private void dfsTraversal(GraphNode node) {

        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        node.isVisited = true;

        while(!stack.isEmpty())
        {
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;

            System.out.print(currentNode.name + " ");

            for(GraphNode node_exec : currentNode.neighbours)
            {
                if(!node_exec.isVisited)
                {
                    stack.push(node_exec);
                    node_exec.isVisited = true;
                }

            }

        }

    }



}
