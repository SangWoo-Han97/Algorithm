package example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * input 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
 * 
 * output 1 2 3 4 5 7 6
 */

public class QueueEx {
	static LinkedList<LinkedList<Integer>> adj;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer("1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7");

		adj = new LinkedList<LinkedList<Integer>>();

		for (int i = 0; i <= 7; i++) {
			adj.add(new LinkedList<Integer>());
		}

		while (st.hasMoreTokens()) {
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adj.get(from).add(to);
			adj.get(to).add(from);
		}

		bfs(1);
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[8];
		
		System.out.print(v + " ");
		q.add(v);
		visited[v] = 1;
		while(!q.isEmpty()) {
			int t = q.poll();
			for(int i = 0; i < adj.get(t).size(); i++) {
				int u = adj.get(t).get(i);
				if(visited[u] == 0) {
					q.add(u);
					visited[u] = 1;
					System.out.print(u + " ");
				}
			}
		}
	}
}
