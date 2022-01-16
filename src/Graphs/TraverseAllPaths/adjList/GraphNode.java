package Graphs.TraverseAllPaths.adjList;

import java.util.ArrayList;

public class GraphNode {

    public String name;
    public int index;
    public boolean isVisited = false;

    public ArrayList<GraphNode> neighbours = new ArrayList<>();

    GraphNode(String name , int index)
    {
        this.name = name;
        this.index = index;
    }


}
