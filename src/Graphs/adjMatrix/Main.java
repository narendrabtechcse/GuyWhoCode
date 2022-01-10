package Graphs.adjMatrix;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        GraphNode A = new GraphNode("A",0);
        GraphNode B = new GraphNode("B",1);
        GraphNode C = new GraphNode("C",2);
        GraphNode D = new GraphNode("D",3);
        GraphNode E = new GraphNode("E",4);

        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(A);
        nodeList.add(B);
        nodeList.add(C);
        nodeList.add(D);
        nodeList.add(E);

        Graph g = new Graph(nodeList);

        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(1,3);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(2,3);
        g.addUndirectedEdge(1,4);

        System.out.println(g.toString());

        g.BFS(0);

        g.DFS();
    }
}