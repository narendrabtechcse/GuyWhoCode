package Graphs.tutort.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {
    private final List<List<Integer>> adjacencyList;
    private final int numVertices;

    public GraphBFS(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source , int destination)
    {
        adjacencyList.get(source).add(destination);
        //adjacencyList.get(destination).add(source); add this also for undirected graph
    }

    //Method to display list of graph
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " : is Connected to :");
            for (Integer vertex : adjacencyList.get(i)) {
                System.out.print("--> " + vertex);
            }
            System.out.println();
        }
    }

    public void bfs(int startVertex)
    {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.println("BFS Traversal starting from index : " + startVertex + " : ");

        while (!queue.isEmpty())
        {
            int vertex = queue.poll();
            System.out.println("Vertex : " + vertex + " ");

            for(int adjacencyVertx : adjacencyList.get(vertex))
            {
                if(!visited[adjacencyVertx])
                {
                    visited[adjacencyVertx] = true;
                    queue.add(adjacencyVertx);
                }
            }
        }
        System.out.println("");
    }
}


