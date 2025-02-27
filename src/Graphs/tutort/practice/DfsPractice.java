package Graphs.tutort.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsPractice {

    public static void main(String[] args) {
        int vertex = 6;

        List<List<Integer>> adjList = new ArrayList<>(vertex);

        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        // int[][] edges = {{1, 2}, {1, 0}, {2, 0}, {2, 3}, {2, 4}};

        int[][] edges = {{1, 2}, {2, 0}, {0, 3}, {4, 5}};

        int[][] matrix =
                {
                        {0, 1, 0, 1},
                        {1, 0, 1, 0},
                        {0, 1, 0, 1},
                        {1, 0, 1, 0}
                };

        for (int[] edge : edges)
            addEdges(edge[0], edge[1], adjList);

        //populateAdjlist(adjList,matrix);

        int source = 2;
        boolean[] visited = new boolean[vertex];
        //DfsRecursive(adjList,source,visited);

        //DfsNonRecursive(adjList,source);

        /*
        DFS for Complete Traversal of Disconnected Undirected Graph
        The above implementation takes a source as an input and prints only those vertices that are reachable from the source
        and would not print all vertices in case of disconnected graph.
        Let us now talk about the algorithm that prints all vertices without any source and the graph maybe disconnected.
        The idea is simple, instead of calling DFS for a single vertex, we call the above implemented DFS for all all non-visited vertices one by one.
        */

        for (int i = 0; i < vertex; i++) {
            if (!visited[i])
                DfsRecursive(adjList, i, visited);
        }

    }


    //non recursive dfs
    private static void DfsNonRecursive(List<List<Integer>> adjList, int source) {
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                System.out.print("--> " + current);
                visited[current] = true;
                for (int neighbour : adjList.get(current)) {
                    stack.push(neighbour);
                }
            }
        }
    }

    private static void populateAdjlist(List<List<Integer>> adjList, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    adjList.get(i).add(j);
                    //adjList.get(j).add(i);
                }
            }
        }
    }

    //recursive dfs
    private static void DfsRecursive(List<List<Integer>> adjList, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print("--> " + source);

        for (int neighbour : adjList.get(source)) {
            if (!visited[neighbour]) {
                DfsRecursive(adjList, neighbour, visited);
            }
        }
    }

    private static void addEdges(int s, int t, List<List<Integer>> adj) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

}
