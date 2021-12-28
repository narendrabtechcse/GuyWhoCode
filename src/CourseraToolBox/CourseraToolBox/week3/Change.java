package CourseraToolBox.CourseraToolBox.week3;



/* 
 Task. The goal in this problem is to find the minimum number of coins needed to change the input value (an integer) into coins with 
 denominations 1, 5, and 10.
Input Format. The input consists of a single integer 𝑚.
Constraints. 1 ≤ 𝑚 ≤ 103.
Output Format. Output the minimum number of coins with denominations 1, 5, 10 that changes 𝑚.
Sample 1.
Input:
2
Output:
2
2 = 1 + 1.
Sample 2.
Input:
28
Output:
6
28 = 10 + 10 + 5 + 1 + 1 + 1.
 * 
 * */



import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
    	//1 , 5 ,10
        //write your code here
    	int numberOfCoins=0;
    	int total=0;
    	if(total==m)
    		return numberOfCoins;
    	
    	while(m-total>=10) {
    	total = total + 10;
    	numberOfCoins++;
    	}
    	
    	while(m-total>=5) {
    		total = total + 5;
        	numberOfCoins++;
    	}
    	
    	while(m-total>=1) {
    		total = total + 1;
        	numberOfCoins++;
    	}
    	
        return numberOfCoins;
    }

    
    
    
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

