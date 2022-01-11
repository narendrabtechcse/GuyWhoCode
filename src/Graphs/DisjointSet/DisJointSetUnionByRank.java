package Graphs.DisjointSet;

public class DisJointSetUnionByRank {

    private int[] root;
    private int[] rank;

    public DisJointSetUnionByRank(int size)
    {
        root = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x)
    {
        while(x!=root[x])
        {
            x = root[x];
        }

        return x;
    }

    public void union(int x,int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY)
        {
            if(rank[rootX]>rank[rootY])
                root[rootY] = rootX;
        }else if(rank[rootX] < rank[rootY])
        {
            root[rootX] = rootY;
        }else{
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
    }

    public boolean isConnected(int x , int y)
    {
        return find(x)==find(y);
    }
}


// App.java
// Test Case
class App2 {
    public static void main(String[] args) throws Exception {
        DisJointSetUnionByRank uf = new DisJointSetUnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.isConnected(1, 5)); // true
        System.out.println(uf.isConnected(5, 7)); // true
        System.out.println(uf.isConnected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.isConnected(4, 9)); // true
    }
}
