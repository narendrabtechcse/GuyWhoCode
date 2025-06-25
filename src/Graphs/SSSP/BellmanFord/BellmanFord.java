package Graphs.SSSP.BellmanFord;

import java.util.Arrays;

class Edge {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class BellmanFord {

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 8; // Number of edges

        Edge[] edges = new Edge[E];

        // Add edges: edges[src, dest, weight]
        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);

        BellmanFord(edges, V, E, 0); // Source vertex = 0
    }

    static void BellmanFord(Edge[] edges, int V, int E, int src) {
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;


        //Relax all edges V-1 times
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }

            //check for negative weight cycles
            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    System.out.println("Graph contains a negative weight cycle");
                    return;
                }
            }
        }

            //print distances
            for (int i = 0; i < V; i++)
                System.out.println("Distance from source 0 to " + i + " is " + dist[i]);

    }
}
