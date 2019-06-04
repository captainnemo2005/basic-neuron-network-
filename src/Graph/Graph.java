package Graph;

import java.util.ArrayList;

public class Graph {
	
	public int vertices;
	
	public ArrayList<Integer>[] adjList;
	
	public Graph(int vertices ) {
		this.vertices = vertices;
		initAdjList();
	}
	
	@SuppressWarnings("unchecked")
	public void initAdjList() {
		this.adjList = new ArrayList[this.vertices];
		
		for(int i = 0 ; i < vertices ; i++)
		{
			// at each slot of the vertice create an array list of the path.
			this.adjList[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int index, int vertices) {
		this.adjList[index].add(vertices);
	}
	
	public void printAllPaths(int source, int destination) {
		
		boolean[] isVisited = new boolean [this.vertices];
		ArrayList<Integer> pathsList = new ArrayList<>();
		
		pathsList.add(source);
		
		printAllPathsUtils(source,destination,isVisited,pathsList);
	}
	
	public void printAllPathsUtils(Integer source, Integer destination, boolean[] isVisited, ArrayList<Integer> pathsList) {
		
		// mark the current node that is now visited
		isVisited[source] = true;
		// check whether the source is the destination
		if(source == destination) {
			System.out.println(pathsList);
			isVisited[source] = false;
			return;
		}
		
		for(Integer i : this.adjList[source]) {
			if(!isVisited[i]) {
				pathsList.add(i);
				printAllPathsUtils(i,destination,isVisited,pathsList);
				
				pathsList.remove(i);
			}
		}
		isVisited[source] = false;
	}
	/**
	 * Testing graph
	 * 
	 * */
	public static void main(String [] args) {
		Graph g = new Graph(4);
        g.addEdge(0,1); 
        g.addEdge(0,2); 
        g.addEdge(0,3); 

        g.addEdge(2,0); 
        g.addEdge(2,1); 
        g.addEdge(2,3);
        
        g.addEdge(1,0);
        g.addEdge(1,2);
        g.addEdge(1,3);
        
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.addEdge(3,2);
        
        int source = 0;
        int destination = 2;
        g.printAllPaths(0,3);
	}
}
