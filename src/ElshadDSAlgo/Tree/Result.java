package ElshadDSAlgo.Tree;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Result {

    /*
     * Complete the 'maxEvents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arrival
     *  2. INTEGER_ARRAY duration
     */

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
    // Write your code here
    int numberOfEvents=0;
    int timeSizeOfEvent=0;
    int cancelEvent =0;
    
    int [][] intervalsInEvent = new int[numberOfEvents][2];
    for(int i=0;i<arrival.size();i++){
        
        intervalsInEvent[i] = (int[]) new int[] {arrival.get(i),arrival.get(i)+duration.get(i)};
    }
    Arrays.sort(intervalsInEvent,(a,b) -> (a[1] - b[1]));
    
    //first event finish time
    int currentTime = intervalsInEvent[0][1];
    
    for(int i=1;i<numberOfEvents;i++) {
    	int[] toSchedl = intervalsInEvent[i];
    	if(toSchedl[0]<currentTime)
    		cancelEvent++;
    	else
    		currentTime = toSchedl[1];
    }
    
	return numberOfEvents-cancelEvent;

    }

}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrivalCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arrival = new ArrayList<>();

        for (int i = 0; i < arrivalCount; i++) {
            int arrivalItem = Integer.parseInt(bufferedReader.readLine().trim());
            arrival.add(arrivalItem);
        }

        int durationCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> duration = new ArrayList<>();

        for (int i = 0; i < durationCount; i++) {
            int durationItem = Integer.parseInt(bufferedReader.readLine().trim());
            duration.add(durationItem);
        }

        int result = Result.maxEvents(arrival, duration);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
