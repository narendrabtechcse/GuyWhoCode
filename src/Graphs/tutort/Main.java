package Graphs.tutort;

public class Main {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {0, 1, 0, 1},
                        {1, 0, 1, 0},
                        {0, 1, 0, 1},
                        {1, 0, 1, 0}
                };

        Graph graph = new Graph(matrix);
        graph.printGraph();
    }
}
