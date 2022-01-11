package Graphs.DisjointSet.LeetCode;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3845/
There are n cities. Some of them are connected, while some are not. If city a is connected
directly with city b, and city b is connected directly with city c, then city a is connected
indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities
outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and
the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
 */

public class NumberOfProvinces {
    private int[] root;
    private int[] rank;

    public int findCircleNum(int[][] isConnected) {
        root = new int[isConnected[0].length];
        rank = new int[isConnected[0].length];

        for (int i = 0; i < isConnected[0].length ;i++) {
            root[i] = i;
            rank[i] = 1;
        }

        for(int i=0 ;i < isConnected[0].length;i++)
        {
            for(int j=0; j< isConnected[0].length;j++){
                if(isConnected[i][j]==1)
                    union(i,j);
            }
        }

        Set set = new HashSet();

        for (int i = 0; i < isConnected[0].length; i++) {
            set.add(find(i));
        }

        return set.size();
    }

    // The find function here is the same as that in the disjoint set with path compression.
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    // The union function with union by rank
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
        }
    }
}