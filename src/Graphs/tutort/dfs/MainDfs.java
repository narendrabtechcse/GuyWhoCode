package Graphs.tutort.dfs;

import java.util.ArrayList;
import java.util.List;

public class MainDfs {
    public static void main(String[] args) {
        int vertices = 5;

        List<List<Integer>> adjList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Define the edges of the graph
        int[][] edges = {
                {1, 2}, {1, 0}, {2, 0}, {2, 3}, {2, 4}
        };

        for (int[] edge : edges) {
            addEdge(adjList, edge[0], edge[1]);
        }

        int source = 1;
        System.out.println("DFS from Source : " + source);
        dfs(source, adjList);
    }

    private static void dfs(int source, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        DFSRec(source, adjList, visited);
    }

    private static void DFSRec(int source, List<List<Integer>> adjList, boolean[] visited) {
        visited[source] = true;
        System.out.print(" -->  " + source);

        for (int neighbour : adjList.get(source)) {
            if (!visited[neighbour]) {
                DFSRec(neighbour, adjList, visited);
            }
        }
    }

    //for undirected graph
    private static void addEdge(List<List<Integer>> adjList, int src, int des) {
        adjList.get(src).add(des);
        adjList.get(des).add(src);
    }
}
