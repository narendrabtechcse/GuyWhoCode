package TopologicalSort.usingkahnalgos;

import java.util.List;

public class TopologicalKahnAlgo {
    static int vertexCount = 6;
    public static void main(String[] args) {
        GraphKahnsTutort graph = new GraphKahnsTutort(vertexCount);

        // Edges
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 },
                { 4, 5 }, { 5, 1 }, { 5, 2 } };

        // Constructing adjacency list
        for (int[] edge : edges) {
            graph.getAdjList().get(edge[0]).add(edge[1]);
        }

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        int[] result = graph.topologicalKahnSort(vertexCount,graph.getAdjList());

        for(int process : result)
        {
            System.out.print("--> "+ process);
        }
    }
}
