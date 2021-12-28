package CourseraToolBox.CourseraToolBox.week5;



import java.util.Scanner;

public class ChangeDP {
	  private static int getChange(int m) {
	        if(m<3)
	            return m;
	        int res = m/4;
	        int rem = m%4;
	        if(rem>2){
	            res += rem/3;
	            rem %= 3; 
	            res += rem;
	        } else if(rem>0) {
	            res+=1;
	        }
	        return res; 
	    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

