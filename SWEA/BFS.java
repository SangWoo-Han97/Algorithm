package example;

import java.io.*;
import java.util.*;

/**
 * input 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
 * 
 * output 1 2 4 6 5 7 3
 */

public class BFS {
	static int[][] matrix;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		matrix = new int[8][8];
		visited = new int[8];

		while (st.hasMoreTokens()) {
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}

		for (int i = 0; i < 8; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

		// 재퀴호출 DFS
		DFSr(1);

		System.out.println();

		// 반복문 DFS
		DFS();
	}

	private static void DFSr(int v) {
		visited[v]++;
		System.out.print(v + " ");

		for (int i = 1; i < 8; i++) {
			if (matrix[v][i] == 1) {
				if (visited[i] < 1) {
					DFSr(i);
				}
			}
		}
	}

	private static void DFS() {
		Stack<Integer> s = new Stack<Integer>();
		int[] visited = new int[8];

		s.push(1);

		while (!s.isEmpty()) {
			int v = s.pop();
			if (visited[v] < 1) {
				visited[v]++;
				System.out.print(v + " ");
				for (int i = 1; i < 8; i++) {
					if (matrix[v][i] == 1) {
						if(visited[i] < 1) {
							s.push(i);
						}
					}
				}
			}
		}
	}
}
