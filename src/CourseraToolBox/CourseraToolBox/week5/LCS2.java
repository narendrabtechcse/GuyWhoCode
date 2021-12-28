package CourseraToolBox.CourseraToolBox.week5;


import java.util.*;

public class LCS2 {

	private static int[][] lcs2(int[] x, int[] y) {
        int m = x.length;
        int n = y.length;

        int[][] table = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            table[i][0] = 0;
        }

        for (int j = 1; j <= n; j++) {
            table[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1])
                    table[i][j] = table[i - 1][j - 1] + 1;
                else if (table[i - 1][j] >= table[i][j - 1])
                    table[i][j] = table[i - 1][j];
                else
                    table[i][j] = table[i][j - 1];
            }
        }
        return table;
    }

    private static int lcsLength(int[] x, int[] y) {
        int[][] lcs = lcs2(x, y);
        return lcs[x.length][y.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcsLength(a, b));
    }
}

