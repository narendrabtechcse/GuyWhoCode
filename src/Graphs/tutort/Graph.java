package Graphs.tutort;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<List<Integer>> adjacencyList;
    private static int numVertices;

    public Graph(int[][] matrix) {
        numVertices = matrix.length;
        this.adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        //initialize the adjacency list
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrix[i][j] != 0) {
                    adjacencyList.get(i).add(j);
                }
            }
        }
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
}


