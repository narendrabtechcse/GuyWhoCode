package com.Hisham;

import java.io.*;
import java.util.*;

// this implementation taken from this youtube channel video : https://www.youtube.com/watch?v=cY4HiiFHO1o

public class SchoolBus {

    private static FastScanner in;
    private static final int INF = 1000 * 1000 * 1000;

    public static void main(String[] args) {
        in = new FastScanner();
        try {
            TSPDynamic tsp = new TSPDynamic(readData());
            printAnswer(new Answer(tsp.getTourCost(), tsp.getTour()));
        } catch (IOException exception) {
            System.err.print("Error during reading: " + exception.toString());
        }
    }

    static class Answer {
        int weight;
        List<Integer> path;

        public Answer(int weight, List<Integer> path) {
            this.weight = weight;
            this.path = path;
        }
    }

    public static class TSPDynamic {

        private final int N;
        private final int START_NODE;
        private final int FINISHED_STATE;
        private final int[][] distance;

        private int minTourCost = Integer.MAX_VALUE;
        private List<Integer> tour = new ArrayList<>();
        private boolean Solver = false;

        public TSPDynamic(int[][] distance) {
            this(0, distance);
        }

        public TSPDynamic(int startNode, int[][] distance) {

            this.distance = distance;
            N = distance.length;
            START_NODE = startNode;

            // The finished state is when the finished state mask has all bits are set to one
            // (meaning all the nodes have been visited).
            FINISHED_STATE = (1 << N) - 1;
        }

        // Returns the optimal tour for the traveling salesman problem.
        public List<Integer> getTour() {
            if (!Solver) solve();
            return tour;
        }

        // Returns the minimal tour cost.
        public int getTourCost() {
            if (!Solver) solve();
            return minTourCost;
        }

        public void solve() {

            int state = 1 << START_NODE;
            Integer[][] memo = new Integer[N][1 << N];
            Integer[][] prev = new Integer[N][1 << N];
            minTourCost = tsp(START_NODE, state, memo, prev);

            // Regenerate path
            int index = START_NODE;
            while (true) {
                if (index == -1) {
                    tour = null;
                    minTourCost = -1;
                    break;
                }
                tour.add(index + 1);
                Integer nextIndex = prev[index][state];
                if (nextIndex == null) break;
                state = state | (1 << nextIndex);
                index = nextIndex;
            }
            Solver = true;
        }

        private int tsp(int i, int state, Integer[][] memo, Integer[][] prev) {

            // Done this tour. Return cost of going back to start node.
            if (state == FINISHED_STATE) return distance[i][START_NODE];

            // Return cached answer if already computed.
            if (memo[i][state] != null) return memo[i][state];

            int minCost = INF;
            int index = -1;
            for (int next = 0; next < N; next++) {

                // Skip if the next node has already been visited.
                if ((state & (1 << next)) != 0) continue;

                int nextState = state | (1 << next);
                int newCost = distance[i][next] + tsp(next, nextState, memo, prev);
                if (newCost < minCost) {
                    minCost = newCost;
                    index = next;
                }
            }

            prev[i][state] = index;
            return memo[i][state] = minCost;
        }
    }

    private static int[][] readData() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                graph[i][j] = INF;

        for (int i = 0; i < m; ++i) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int weight = in.nextInt();
            graph[u][v] = graph[v][u] = weight;
        }
        return graph;
    }

    private static void printAnswer(final Answer answer) {
        System.out.println(answer.weight);
        if (answer.weight == -1)
            return;
        for (int x : answer.path)
            System.out.print(x + " ");
        System.out.println();
    }

    static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}