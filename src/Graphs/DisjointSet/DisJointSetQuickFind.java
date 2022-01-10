package Graphs.DisjointSet;

class DisJointQuickFindSet {

    public static void main(String[] args)
    {

        UnionFind uf = new UnionFind(10);
        //1-2-5-6-7 3-8-9 4

        uf.union(1,2);
        uf.union(2,5);
        uf.union(5,6);
        uf.union(6,7);
        uf.union(3,8);
        uf.union(8,9);

        System.out.println(uf.isConnected(1,5));//true
        System.out.println(uf.isConnected(2,5));//true
        System.out.println(uf.isConnected(5,7));//true
        System.out.println(uf.isConnected(4,2));//false

        // 1-2-5-6-7 3-8-9-4

        System.out.println("before connecting 9,4 " + uf.isConnected(9,4));//false

        uf.union(9,4);
        System.out.println("after connecting 9,4 " + uf.isConnected(9,4));//true


        System.out.println("before connecting 6,9 " + uf.isConnected(6,9));//false
        uf.union(6,9);
        //System.out.println(uf.isConnected(6,9));
        System.out.println("after connecting 6,9 " + uf.isConnected(9,4));//true

    }

}

class UnionFind{

    private int[] root;

    UnionFind(int x)
    {
        root = new int[x];
        for (int i = 0; i < x; i++) {
            root[i] = i;
        }
    }


    public int find(int x)
    {
        return root[x];
    }

    public boolean isConnected(int x , int y)
    {
        return find(x) == find(y);
    }

    public void union(int x , int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY)
        {

            for (int i = 0; i <root.length ; i++) {
                if(root[i]==rootY)
                    root[i] = rootX;
            }

        }
    }
}
