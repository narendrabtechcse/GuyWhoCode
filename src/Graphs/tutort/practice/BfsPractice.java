package Graphs.tutort.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsPractice {
    public static void main(String[] args) {
        int numVertex = 4;
        List<List<Integer>> adjList = new ArrayList<>(numVertex);

        for (int i = 0; i < numVertex; i++) {
            adjList.add(new ArrayList<>());
        }

        int[][] matrix =
                {
                        {0, 1, 0, 1},
                        {1, 0, 1, 0},
                        {0, 1, 0, 1},
                        {1, 0, 1, 0}
                };

        for (int i = 0; i < numVertex; i++) {
            {
                for (int j = 0; j < numVertex; j++) {
                    if (matrix[i][j] != 0) {
                        adjList.get(i).add(j);
                        adjList.get(j).add(i);
                    }
                }
            }
        }

       // int startVertex = 0;
       // bfsTraversal(adjList, startVertex);

        boolean[] visited = new boolean[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                bfsTravere(adjList, visited , i);
            }
        }
    }

    private static void bfsTraversal(List<List<Integer>> adjList,  int startVertex) {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            int element = queue.poll();
            System.out.print("-->" + element);
            visited[element] = true;
            for (int neighbour : adjList.get(element)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    private static void bfsTravere(List<List<Integer>> adjList, boolean[] visited , int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            int element = queue.poll();
            System.out.print("-->" + element);
            visited[element] = true;
            for (int neighbour : adjList.get(element)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}
