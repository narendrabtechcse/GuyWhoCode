package ElshadDSAlgo.adjMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	int[][] adjacencyMatrix;

	public Graph(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}
	
	public void addUndirectedEdge(int i , int j) {
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
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
			for(int j : adjacencyMatrix[i]) {
				s.append((j) + " ");
			}
			
			s.append("\n");
			
		}
		return s.toString();
	}


	//get Neighbours
	public ArrayList<GraphNode> getNeighbours(GraphNode node)
	{
		 ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
		 int nodeIndex = node.index;
		 for(int i=0;i<adjacencyMatrix.length;i++)
		 {
			 if(adjacencyMatrix[nodeIndex][i]==1)
				 neighbors.add(nodeList.get(i));
		 }
		 return neighbors;
	}

	//BSF Internal
	void bfsVisit(GraphNode node)
	{
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		while(!queue.isEmpty())
		{
			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");

			ArrayList<GraphNode> neighbours = getNeighbours(currentNode);

			for(GraphNode neighbour: neighbours){
				if(!neighbour.isVisited) {
					queue.add(neighbour);
					neighbour.isVisited = true;
				}
			}
		}
	}


	public void bfs() {
		for(GraphNode node : nodeList)
		{
			if(!node.isVisited){
				bfsVisit(node);
			}
		}
	}

	void dfsVisit(GraphNode node)
	{
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);

		while(!stack.isEmpty()){
			GraphNode currentNode = stack.pop();
			currentNode.isVisited=true;
			System.out.println(currentNode.name + " ");
			ArrayList<GraphNode> neighbours = getNeighbours(currentNode);

			for(GraphNode neighbour : neighbours)
			{
				if(!neighbour.isVisited)
					stack.push(neighbour);
				neighbour.isVisited = true;
			}
		}
	}


	void dfs()
	{
		for(GraphNode node : nodeList)
		{
			if(!node.isVisited)
				dfsVisit(node);
		}
	}
}


