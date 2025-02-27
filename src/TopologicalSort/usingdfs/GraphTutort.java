package TopologicalSort.usingdfs;

import java.util.ArrayList;
import java.util.List;

public class GraphTutort {
    private int V;   // No. of vertices

    private List<List<Integer>> adjList= new ArrayList<>(); // Adjacency List

    //Constructor
    public GraphTutort(int v)
    {
        V = v;
        for (int i=0; i<v; ++i)
            adjList.add(new ArrayList<>());
    }

    public void addEdge(int source, int destination)
    {
        adjList.get(source).add(destination);
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }
}
