package CourseraToolBox.CourseraToolBox.week2;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fibonacci_partial_sum {

	static long sum=0;
	private static long getFibonacciSum(long from , long to) {
		long sum = 0;

    long curr = 0;
    long next  = 1;

    for (long i = 0; i <= to; ++i) {
        if (i >= from) {
            sum += curr;
        }

        long new_curr = next;
        next = next + curr;
        curr = new_curr;
    }

    return sum % 10;
    }
    
	public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        long a = scanner.nextInt();
        
        long b = scanner.nextInt();
       
        
        System.out.println(getFibonacciSum(a,b));
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
