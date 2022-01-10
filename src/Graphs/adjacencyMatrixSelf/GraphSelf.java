package Graphs.adjacencyMatrixSelf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphSelf {

    ArrayList<GraphNode> graphNodes = new ArrayList<>();
    int[][] adjMatrix ;
    boolean[] isVisited;

    GraphSelf(ArrayList<GraphNode> graphNodes){

        this.graphNodes=graphNodes ;

        adjMatrix = new int[graphNodes.size()][graphNodes.size()];

        isVisited = new boolean[graphNodes.size()];

    }

    public void addEdge(int i,int j)
    {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("  ");

        for (int i = 0; i < graphNodes.size(); i++) {
            s.append(graphNodes.get(i).name + " ");
        }

        s.append("\n");

        for (int i = 0; i < graphNodes.size(); i++) {

            s.append(graphNodes.get(i).name + ":");
            for(int j : adjMatrix[i]) {
                s.append((j) + " ");
            }

            s.append("\n");

        }
        return s.toString();
    }

    public void bfsTraversal(int startNode) {

        boolean[] isVisited = new boolean[graphNodes.size()];

        for (int i = 0; i < graphNodes.size(); i++) {
            isVisited[i] = false;
        }

        List<Integer> q = new LinkedList();

        q.add(startNode);
        isVisited[startNode] = true;

        int val;
        while(!q.isEmpty())
        {
            val = q.get(0);

            System.out.print(val + " ");

            q.remove(q.get(0));


            for (int i = 0; i < graphNodes.size(); i++) {

                if(adjMatrix[val][i]==1 && !isVisited[i])
                {
                    q.add(i);
                    isVisited[i] = true;
                }

            }

        }
    }

    public void DFS()
    {
        System.out.println();
        System.out.println("The DFS traversal of the Graph is : ");
        System.out.println();

        for (int i = 0; i < graphNodes.size(); i++) {
            isVisited[i] = false;
        }

        for (int i = 0; i < graphNodes.size(); i++) {
            if(!isVisited[i])
                dfsTraversal(i);
        }
    }

    public void dfsTraversal(int i)
    {
        Stack<Integer> stack = new Stack();

        stack.push(i);
        isVisited[i] = true;

        int vis;

        while(!stack.isEmpty())
        {
            vis = stack.pop();
            isVisited[vis] = true;

            System.out.print(vis + " ");

            for (int j = 0; j < graphNodes.size(); j++) {

                if(adjMatrix[vis][j]==1 && !isVisited[j])
                {
                    stack.push(j);
                    isVisited[j] = true;
                }

            }

        }

    }
}
