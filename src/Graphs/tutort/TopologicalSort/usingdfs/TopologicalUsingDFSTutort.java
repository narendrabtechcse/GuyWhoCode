package Graphs.tutort.TopologicalSort.usingdfs;

import java.util.List;
import java.util.Stack;

public class TopologicalUsingDFSTutort {
    static int vertexCount = 6;
    public static void main(String[] args) {
        GraphTutort graph = new GraphTutort(vertexCount);

        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        topologicalSort(graph);
    }

    private static void topologicalSort(GraphTutort graph) {

        List<List<Integer>> adjList = graph.getAdjList();
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i< vertexCount;i++)
        {
            visited[i] = false;
        }

        for(int i=0;i< vertexCount;i++)
        {
            if(!visited[i]) {
                dfsUtil(i, adjList, visited, stack);
            }
        }

        // Print contents of stack
        while (!stack.empty())
            System.out.print(stack.pop() + " ");

    }

    private static void dfsUtil(int vertex, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {

        visited[vertex] = true;

        for(int current : adjList.get(vertex))
        {
            if(!visited[current])
            {
                dfsUtil(current,adjList,visited,stack);
            }
        }

        stack.push(vertex);
    }
}
