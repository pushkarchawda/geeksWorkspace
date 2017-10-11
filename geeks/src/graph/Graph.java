package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class Graph {
	
	LinkedList<Integer> a[];
	int V;
	
	Graph(int edges)
	{
		V = edges;	
		a = new LinkedList[edges];
		for(int i=0;i<edges;i++)
		{
			a[i] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stubGraph g = new Graph(4);
		Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.bfs(2);

	}
	
	public void bfs(int startNode)
	{
		boolean visited[] = new boolean[V];
		Arrays.fill(visited, false);
		LinkedList<Integer> queue = new LinkedList<>();
		visited[startNode] = true;
		queue.add(startNode);
		
		while(queue.size()!=0)
		{
			startNode = queue.poll();
			System.out.println(startNode);
			
			Iterator<Integer> it = a[startNode].listIterator();
			while(it.hasNext())
			{
				int n = it.next();
				if(!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		
		
		
		
		
	}
	
	public void addEdge(int u, int v)
	{
		a[u].add(v);
	}

}
