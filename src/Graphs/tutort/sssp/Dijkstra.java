package Graphs.tutort.sssp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] args) {
        GraphD graph = new GraphD(5);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 2);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 4, 4);
        graph.addEdge(2, 3, 9);
        graph.addEdge(4, 2, 8);
        graph.addEdge(4, 3, 2);

        graph.dijkstra(0);

    }
}

class Node implements Comparable<Node> {

    int u;
    int weight;

    Node(int node, int weight) {
        this.u = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class GraphD {
    private int vertices;
    private List<List<Node>> adjList;

    public GraphD(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
    }

    public void dijkstra(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.u;

            for (Node neighbour : adjList.get(u)) {
                int v = neighbour.u;
                int weight = neighbour.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        printShortestPath(src, dist);
    }

    private void printShortestPath(int src, int[] dist) {
        System.out.println("Shortest path from source node " + src + " : ");

        for (int i = 0; i < dist.length; i++) {
            System.out.println("Node " + i + " ----> " + dist[i]);
        }
    }
}