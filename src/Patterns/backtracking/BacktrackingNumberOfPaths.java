package Patterns.backtracking;

/*
Problem :https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach the destination at (n - 1, n - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list. The driver will output "-1" automatically.

Examples:

Input: mat[][] = [[1, 0, 0, 0],
                [1, 1, 0, 1],
                [1, 1, 0, 0],
                [0, 1, 1, 1]]
Output: DDRDRR DRDDRR
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
Input: mat[][] = [[1, 0],
                [1, 0]]
Output: -1
Explanation: No path exists and destination cell is blocked.
Expected Time Complexity: O(3n^2)
Expected Auxiliary Space: O(l * x)
Here l = length of the path, x = number of paths.

Constraints:
2 ≤ n ≤ 5
0 ≤ mat[i][j] ≤ 1
 */


import java.util.ArrayList;

public class BacktrackingNumberOfPaths {

    // Array Initialised and Assigned
    static int[][] arr = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 },{1, 1, 0, 0} , {0, 1, 1, 1} };

    public static void main(String[] args) {

        System.out.println(new Solution().findPath(arr));

    }
}

class Solution
{
    public ArrayList<String> findPath(int[][] mat)
    {
        int n = mat.length;

        ArrayList<String> paths = new ArrayList<>();

        boolean[][] visited = new boolean[n][n];

        findPaths(mat , n , 0 , 0 , "" , paths , visited);

        return paths;
    }

    private void findPaths(int[][] mat, int n, int row, int col, String path, ArrayList<String> paths, boolean[][] visited) {

        if(row == n-1 && col == n-1)
        {
            paths.add(path);
            return;
        }

        visited[row][col] = true;


        //move down row+1 , col
        if(isSafe(mat, n, row+1, col, visited))
        {
            findPaths(mat,n,row+1,col , path+"D",paths,visited);
        }


        //move up row-1 , col
        if(isSafe(mat, n, row-1, col, visited))
        {
            findPaths(mat,n,row-1,col , path+"U",paths,visited);
        }


        //move right row , col+1
        if(isSafe(mat, n, row, col+1, visited))
        {
            findPaths(mat,n,row,col+1 , path+"R",paths,visited);
        }


        //move left row , col-1
        if(isSafe(mat, n, row, col-1, visited))
        {
            findPaths(mat,n,row,col-1 , path+"L",paths,visited);
        }


        //Unmarking is needed for Backtracking

        visited[row][col] = false;
    }

    private static boolean isSafe(int[][] mat , int n , int row , int col , boolean[][] visited)
    {
        return row>=0 && row<n && col>=0 && col<n && mat[row][col]==1 && !visited[row][col];
    }
}

