package javamultithreadingandconcurrencysimplifiedudemythreading;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PatternSearch {

    public static void main(String[] args) throws Exception {

        String pattern = "public";

        File dir = new File("../");
        File [] files = dir.listFiles();

        System.out.println(dir);
        System.out.println(files[0]);

        PatternFinder finder = new PatternFinder();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<String, Object> resultMap = new HashMap<String,Object>();

        long startTime = System.currentTimeMillis();

        for (File file : files) {

            Future<List<Integer>> future =
                    executor.submit(
                            new Callable<List<Integer>>() {
                                public List<Integer> call() {
                                    List<Integer> lineNumbers = finder.find(file, pattern);
                                    return lineNumbers;
                                }
                            });

            resultMap.put(file.getName(), future);
        }

        waitForAll( resultMap );

        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            System.out.println( pattern + " found at - " + entry.getValue() + " in file " + entry.getKey());
        }


        // Serial - 3003

        System.out.println(" Time taken for search - " + (System.currentTimeMillis() - startTime));

    }

    private static void waitForAll(Map<String, Object> resultMap) throws Exception {

        Set<String> keys =  resultMap.keySet();

        for (String key : keys) {
            Future<List<Integer>> future = (Future<List<Integer>>) resultMap.get(key);
            while (! future.isDone()) {
                Thread.yield(); // idle
            }
            resultMap.put(key, future.get());
        }

    }

}

class PatternFinder {

    public List<Integer> find(File file, String pattern) {

        List<Integer> lineNumbers = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int lineNo = 1;
            String line;
            while ( (line = br.readLine()) != null) {
                if (line.contains(pattern)) {
                    lineNumbers.add(lineNo);
                }
                lineNo++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Just introduced the delay for demo.
        try { Thread.sleep(1000); } catch(Exception e) {}

        return lineNumbers;
    }

}

