package ArraysPbs;

/*
https://leetcode.com/problems/rotting-oranges/

You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1.
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public  static  void  main(String args[]){

        int arr[][] = {{2, 1, 1},{1, 1, 0},{0,1,1} };

        int numberOfMinutes = new RottingOranges().orangesRotting(arr);

        System.out.println("numberOfMinutes : "+numberOfMinutes);
    }

    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        int count_fresh = 0;
        Queue<int[]> que = new LinkedList<>();

        // count fresh fruit and store location of rotten fruit in queue
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    count_fresh++;
                } else if(grid[i][j] == 2) {
                    que.offer(new int[]{i,j});
                }
            }
        }

        if(count_fresh == 0) return 0; // if there is no fresh fruit already, return 0

        // BFS
        while(!que.isEmpty()) {
            count++;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int[] rot = que.poll();
                for(int[] dir : dirs) {
                    int x = rot[0] + dir[0];
                    int y = rot[1] + dir[1];

                    if(x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    que.offer(new int[]{x,y});
                    count_fresh--;
                }
            }
        }

        return count_fresh == 0 ? count - 1 : -1;
    }
}
