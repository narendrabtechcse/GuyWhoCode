package Graphs.DisjointSet.LeetCode;

/*
https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3910/

You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a
list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge
between nodes ai and bi in the graph.
Return true if the edges of the given graph make up a valid tree, and false otherwise.

 */

//this problem most important thing is count

/*
For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't
possibly be fully connected. Any more, and it has to contain cycles. Additionally, if
the graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle, and therefore must be a tree!
 */

public class GraphValidTree {

    int[] root;
    int[] rank;
    int count;

    public boolean validTree(int n, int[][] edges) {
        count = n;
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: edges){
            if(isConnected(edge[0], edge[1])){
                return false;
            }else{
                union(edge[0], edge[1]);
            }
        }
        return count==1;
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }

            count--;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
