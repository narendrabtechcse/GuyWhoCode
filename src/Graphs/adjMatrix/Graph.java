package Graphs.adjMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjMatrix;
    boolean[] isVisited;

    Graph(ArrayList<GraphNode> nodeList)
    {
        this.nodeList = nodeList;
        adjMatrix = new int[nodeList.size()][nodeList.size()];
        isVisited = new boolean[nodeList.size()];
    }

    public void addUndirectedEdge(int i,int j)
    {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("  ");

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }

        s.append("\n");

        for (int i = 0; i < nodeList.size(); i++) {

            s.append(nodeList.get(i).name + ":");
            for(int j : adjMatrix[i]) {
                s.append((j) + " ");
            }

            s.append("\n");

        }
        return s.toString();
    }

    public void BFS(int startNode)
    {
        boolean[] isVisited = new boolean[nodeList.size()];

        for (int i = 0; i < nodeList.size(); i++) {
            isVisited[i] = false;
        }

        List<Integer> q = new ArrayList<>();
        q.add(startNode);
        isVisited[startNode] = true;

        int vis;

        while(!q.isEmpty())
        {
            vis = q.get(0);

            System.out.print(vis + " ");
            q.remove(q.get(0));

            for(int i=0;i<nodeList.size();i++)
            {
                if(adjMatrix[vis][i]==1 && (!isVisited[i]))
                {
                    q.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }


    void DFS() {


        for (int i = 0; i < nodeList.size(); i++) {
            isVisited[i] = false;
        }

        System.out.println();

        System.out.print("dfs" + " : ");

        for (int i = 0; i < nodeList.size(); i++) {
            if(!isVisited[i])
                dfsVisit(i);
        }
    }


    public void dfsVisit(int startNode)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        isVisited[startNode] = true;

        int vis;

        while(!stack.isEmpty())
        {
            vis = stack.pop();
            isVisited[vis] = true;


            System.out.print(vis + " ");

            for(int i=0;i<nodeList.size();i++)
            {
                if(adjMatrix[vis][i]==1 && (!isVisited[i]))
                {
                    stack.push(i);
                    isVisited[i] = true;
                }
            }
        }
    }

}
