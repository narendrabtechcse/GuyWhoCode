package Graphs.tutort.TopologicalSort.usingkahnalgos;

import java.util.*;

public class GraphKahnsTutort {
    int VertexCount;

    List<List<Integer>> adjList = new ArrayList<>();

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    GraphKahnsTutort(int V) {
        this.VertexCount = V;

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
    }

    public int[] topologicalKahnSort(int vertexCount, List<List<Integer>> adjList) {

        int[] inDegree = new int[vertexCount];

        // Array to store indegree of each vertex
        for (int i = 0; i < vertexCount; i++) {
            for (int neighbour : adjList.get(i)) {
                inDegree[neighbour]++;
            }
        }

        // Queue to store vertices with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertexCount; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[vertexCount];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[index++] = current;

            for (int neighbour : adjList.get(current)) {
                inDegree[neighbour]--;

                if (inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        // Check for cycle
        if (index != vertexCount) {
            System.out.println("Graph contains cycle!");
            return new int[0];
        }
            return result;
    }
}