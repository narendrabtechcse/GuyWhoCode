package Graphs.adjacencyMatrixSelf;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args)
    {
        ArrayList<GraphNode> nodes = new ArrayList<>();

        GraphNode A = new GraphNode("A",0);
        GraphNode B = new GraphNode("B",1);
        GraphNode C = new GraphNode("C",2);
        GraphNode D = new GraphNode("D",3);
        GraphNode E = new GraphNode("E",4);
        GraphNode F = new GraphNode("F",5);
        GraphNode G = new GraphNode("G",6);

        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        nodes.add(D);
        nodes.add(E);
        nodes.add(F);
        nodes.add(G);

        GraphSelf graphSelf = new GraphSelf(nodes);

        graphSelf.addEdge(0,1);
        graphSelf.addEdge(1,2);
        graphSelf.addEdge(0,3);
        graphSelf.addEdge(3,2);

        graphSelf.addEdge(2,4);
        graphSelf.addEdge(2,5);

        graphSelf.addEdge(4,6);
        graphSelf.addEdge(5,6);

        System.out.println(graphSelf.toString());

        graphSelf.bfsTraversal(0);

        graphSelf.DFS();


    }
}
