package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsSourceToTarget {


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> paths = new ArrayList<List<Integer>>();

        if(graph==null || graph.length==0)
        {
            return paths;
        }


        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<Integer>();

        path.add(0);
        queue.add(path);

        while(!queue.isEmpty())
        {

            List<Integer> currentPath = queue.poll();
            int node = currentPath.get(currentPath.size()-1);

            for(int nextNode:graph[node])
            {
                List<Integer> tmpPath = new ArrayList<>(currentPath);
                tmpPath.add(nextNode);

                if(nextNode == graph.length-1)
                {
                    paths.add(new ArrayList<>(tmpPath));
                }else{
                    queue.add(new ArrayList<>(tmpPath));
                }


            }

        }

        return paths;
    }

}
