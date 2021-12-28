package CourseraToolBox.CourseraToolBox.week2;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fibonacci_last_digit {


    static long getFibonacci(int number) { 
    	
    	if (number <= 1) {
        return number;
    }

    int[]mem = new int[number + 1];
    mem[0] = 0; mem[1] = 1;
    for (int index = 2 ; index <= number ; index++) {
    	mem[index] = (mem[index - 1] + mem[index - 2]) % 10;
    }
    return mem[number];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        
        System.out.println(getFibonacci(n));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
