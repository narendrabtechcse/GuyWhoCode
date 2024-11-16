package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    public static void main(String[] args) {
            System.out.println(new NQueen().solveNQueens(4));
    }
}


class NQueen {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // populate the Board
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j] = '.';
            }
        }

        solveQueenHelper(result,board,0,n);

        return result;

    }

    private void solveQueenHelper(List<List<String>> result, char[][] board , int currentQueen , int n)
    {
        //base condition
        if(currentQueen==n)
        {
            result.add(construct(board));
            return;
        }

        for(int col=0;col<n ; col++)
        {
            if(isSafe(board, currentQueen , col , n))
            {
                board[currentQueen][col] = 'Q';
                solveQueenHelper(result,board , currentQueen+1,n);
                board[currentQueen][col] = '.';
            }
        }

    }

    private boolean isSafe(char[][] board , int row , int col , int n)
    {
        //check fol col
        for(int i=0 ; i<row ; i++)
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }

        for(int i=row-1,j=col-1; i>=0 && j>=0 ; i--,j--)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }


        for(int i=row-1 , j=col+1; i>=0 && j<n ; i--,j++)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board)
    {
        List answer = new ArrayList<>();

        for(int i=0;i<board.length;i++)
        {
            answer.add(new String(board[i]));
        }

        return answer;
    }



   /* public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        //populate the Board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solveQueueHelper(result, board, 0, n);

        return result;
    }

    private void solveQueueHelper(List<List<String>> result, char[][] board, int currentQueue, int n) {

        //Base condition
        if (currentQueue == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, currentQueue, col, n)) {
                board[currentQueue][col] = 'Q';
                solveQueueHelper(result, board, currentQueue + 1, n);
                board[currentQueue][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        //check for column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; j >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List answer = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            answer.add(new String(board[i]));
        }
        return answer;
    }*/
}
