package Graphs.DisjointSet.LeetCode;

public class OptimizeWaterDistributionInaVillage {

    int[] root;
    int[] rank;
    static int count;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        count = n;
        root = new int[n+1];
        rank = new int[n+1];
        int well=1;
        int finalCost = 0;

        for (int i = 1; i <= n; i++) {
            root[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: pipes){

            if(!isConnected(edge[1], edge[2])){
                int pipeCost = edge[0];
                int wellCost = wells[well-1];

                if(pipeCost<wellCost)
                {
                    finalCost += pipeCost;
                }else{
                    finalCost += wellCost;
                }
                union(edge[1], edge[2]);
                well++;
            }
            if(count==1)
                break;
        }

        return finalCost;
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


    public static void main(String args[])
    {
        System.out.println(new OptimizeWaterDistributionInaVillage().minCostToSupplyWater(3, new int[] {1,2,2}, new int[][] {{1,2,1},{2,3,1}}));
    }


}
