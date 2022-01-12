package Graphs.DisjointSet.LeetCode;

/*
https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3911/

You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
indicates that there is an edge between ai and bi in the graph.
Return the number of connected components in the graph.
*/

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponentsInUDGraph {

    public int countComponents(int n, int[][] edges) {
        Union uf = new Union(n);
        Set set = new HashSet();

        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);
        }

        for(int i = 0;i < n;i++) {
            set.add(uf.find(i));
        }

        return set.size();
    }
}


class Union{

    private int[] root;
    private int[] rank;
    private int size;

    public Union(int n)
    {
        this.size = n;
        root = new int[n];
        rank = new int[n];

        for(int i = 0;i<size;i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x)
    {
        if(x==root[x])
        {
            return x;
        }

        return root[x] = find(root[x]);
    }

    public void union(int x , int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY)
        {
            if(rank[rootX] > rank[rootY])
            {
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY])
            {
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX] +=1;
            }
        }

    }

}
