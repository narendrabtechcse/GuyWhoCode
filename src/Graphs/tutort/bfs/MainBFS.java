package Graphs.tutort.bfs;

public class MainBFS {
    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(2,4);

        graph.bfs(0);
    }
}
