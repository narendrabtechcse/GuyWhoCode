package Graphs.SSSP.SSSPPUsingBFS;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {

        ArrayList<GraphNode> nodeList = new ArrayList<>();
        GraphNode A = new GraphNode("A",0);
        GraphNode B = new GraphNode("B",1);
        GraphNode C = new GraphNode("C",2);
        GraphNode D = new GraphNode("D",3);
        GraphNode E = new GraphNode("E",4);
        GraphNode F = new GraphNode("F",5);
        GraphNode G = new GraphNode("G",6);

        nodeList.add(A);
        nodeList.add(B);
        nodeList.add(C);
        nodeList.add(D);
        nodeList.add(E);
        nodeList.add(F);
        nodeList.add(G);

        GraphList  graphList = new GraphList(nodeList);

        graphList.addUndirectedEdge(0,1);
        graphList.addUndirectedEdge(0,2);
        graphList.addUndirectedEdge(1,3);
        graphList.addUndirectedEdge(1,6);
        graphList.addUndirectedEdge(2,3);
        graphList.addUndirectedEdge(2,4);
        graphList.addUndirectedEdge(3,5);
        graphList.addUndirectedEdge(4,5);
        graphList.addUndirectedEdge(5,6);

        graphList.BFSForSSSPP(A);


    }
}
