package Graphs.tutort.graphs;

import java.util.*;

public class bfsTraverse {

    public static void main(String[] args) {

        int numVertices = 6;

        List<List<Integer>> adjList = new ArrayList<>();
        int[][] edges = {{1, 2}, {2, 0}, {0, 3}, {4, 5}};

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges)
            addEdges(edge[0], edge[1], adjList);

        int source = 2;
        boolean[] visited = new boolean[adjList.size()];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                bfsTravarsal(adjList, visited, i);
            }
        }

        boolean[] visited1 = new boolean[adjList.size()];
        for (int i = 0; i < numVertices; i++) {
            if (!visited1[i]) {
                dfsTravarsal(adjList, visited1, i);
            }
        }

    }

    private static void dfsTravarsal(List<List<Integer>> adjList, boolean[] visited, int startVertex) {

        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        System.out.println("Dfs Traversal : ");

        while(!stack.isEmpty())
        {
            int element = stack.pop();

            if(!visited[element]) {

                System.out.print(" --> " + element);
                visited[element] = true;
                for (int neighbour : adjList.get(element)) {
                    stack.push(neighbour);
                }
            }
        }


    }

    private static void addEdges(int s, int t, List<List<Integer>> adj) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    private static void bfsTravarsal(List<List<Integer>> adjList, boolean[] visited, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;
        System.out.println("Bfs Traversal : ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            visited[vertex] = true;
            System.out.print(" --> " + vertex);
            for (int neighbour : adjList.get(vertex)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}
