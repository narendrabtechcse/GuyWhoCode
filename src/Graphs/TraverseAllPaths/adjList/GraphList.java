package Graphs.TraverseAllPaths.adjList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphList {

    ArrayList<GraphNode> nodeList = new ArrayList<>();

    GraphList(ArrayList<GraphNode> nodes)
    {
        this.nodeList = nodes;
    }

    // For printing Graph to the console

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j =0; j < nodeList.get(i).neighbours.size(); j++) {
                if (j == nodeList.get(i).neighbours.size()-1 ) {
                    s.append((nodeList.get(i).neighbours.get(j).name) );
                } else {
                    s.append((nodeList.get(i).neighbours.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void addUndirectedEdge(int i, int j) {

        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);

        first.neighbours.add(second);
        second.neighbours.add(first);
    }



    public void printAllPaths(int source, int dest)
    {
        boolean[] isVisited = new boolean[nodeList.size()];
        ArrayList<GraphNode> pathList = new ArrayList<>();
        pathList.add(nodeList.get(source));
        printAllPathsHelper(source, dest, isVisited, pathList);
    }


    public void printAllPathsHelper(int start, int end, boolean[] isVisited, List<GraphNode> tempPathList)
    {
        if (start == end) {
            System.out.println();
            for (int i = 0; i <tempPathList.size() ; i++) {

                System.out.print(tempPathList.get(i).name);
                if(i!= tempPathList.size()-1)
                    System.out.print(" --> ");
            }
            System.out.println();
            return;
        }

        isVisited[start] = true;

        for (GraphNode i : nodeList.get(start).neighbours) {
            if (!isVisited[i.index]) {
                tempPathList.add(i);
                printAllPathsHelper(i.index, end, isVisited, tempPathList);
                tempPathList.remove(i);//backtracking
            }
        }
        isVisited[start] = false;
    }

}
