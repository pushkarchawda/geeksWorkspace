package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAdjacency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = new int[][]{{0,0,0,1},
									{0,0,0,0},
									{0,1,0,1},
									{0,0,1,0}};
           
           BFS(graph, 0);

	}

	private static void BFS(int[][] graph, int src) {

		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		boolean v[] = new boolean[graph[0].length];
		// v[src] = true;
		while (!q.isEmpty()) {
			int i = q.poll();
			if (!v[i])
				System.out.print(i + " -> ");
			v[i] = true;
			for (int j = 0; j < graph[0].length; j++) {
				if (graph[i][j] == 1 && j != i && !v[j]) {
					q.add(j);
				}
			}
		}

	}

}
