package Graphs.TraverseAllPaths.adjList;

import java.util.ArrayList;

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

        GraphList graphList = new GraphList(nodes);

        graphList.addUndirectedEdge(0,1);
        graphList.addUndirectedEdge(1,2);
        graphList.addUndirectedEdge(0,3);
        graphList.addUndirectedEdge(3,2);

        graphList.addUndirectedEdge(2,4);
        graphList.addUndirectedEdge(2,5);

        graphList.addUndirectedEdge(4,6);
        graphList.addUndirectedEdge(5,6);

        System.out.println(graphList.toString());

        //graphList.bfsTraversal(0);

        graphList.printAllPaths(0,1);

        //graphList.bfsTraversal(A);


    }


}
