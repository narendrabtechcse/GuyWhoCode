package ElshadDSAlgo.Tree;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result1 {

    /*
     * Complete the 'countAnalogousArrays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY consecutiveDifference
     *  2. INTEGER lowerBound
     *  3. INTEGER upperBound
     */

    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {
    // Write your code here
    int maxValinAnalogousArray=lowerBound;
    int minValinAnalogousArray=upperBound;
    int previousValue= lowerBound - consecutiveDifference.get(0);
    //System.out.println( "previousValue " + previousValue);
    for (int i=1;i<consecutiveDifference.size();i++) {
        
    	System.out.println( "previousValue " + previousValue);
    	
        int valueInAnalArray = previousValue - consecutiveDifference.get(i);
        
        System.out.println( "valueInAnalArray " + valueInAnalArray);
        
         if(valueInAnalArray<lowerBound || valueInAnalArray > upperBound)
        return 0;
        
        if(valueInAnalArray>maxValinAnalogousArray)
        maxValinAnalogousArray = valueInAnalArray;
        
        if(valueInAnalArray<minValinAnalogousArray)
        	minValinAnalogousArray = valueInAnalArray;
        
        previousValue = valueInAnalArray;
        
        System.out.println( "maxValinAnalogousArray " + maxValinAnalogousArray);
        System.out.println( "minValinAnalogousArray " + minValinAnalogousArray);
    }
    
    System.out.println(upperBound-maxValinAnalogousArray+ lowerBound-minValinAnalogousArray+1);
    
    return upperBound-maxValinAnalogousArray+ lowerBound-minValinAnalogousArray+1;

    }

}

public class Testing {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abc.txt"));

        int consecutiveDifferenceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> consecutiveDifference = new ArrayList<>();

        for (int i = 0; i < consecutiveDifferenceCount; i++) {
            int consecutiveDifferenceItem = Integer.parseInt(bufferedReader.readLine().trim());
            consecutiveDifference.add(consecutiveDifferenceItem);
        }

        int lowerBound = Integer.parseInt(bufferedReader.readLine().trim());

        int upperBound = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result1.countAnalogousArrays(consecutiveDifference, lowerBound, upperBound);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
