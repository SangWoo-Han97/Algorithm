package stack1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ID_1219_2 {
	static int[][] matrix;
	static boolean isExist = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			matrix = new int[100][100];
			isExist = false;
			
			for (int i = 0; i < N; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = 1;
			}

			DFS();
			
			System.out.print("#" + test_case + " ");
			if (isExist) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	private static void DFS() {
		Stack<Integer> s = new Stack<Integer>();
		int[] visited = new int[100];
		
		s.push(0);
		
		while(!s.isEmpty()) {
			int v = s.pop();
			if(visited[v] < 1) {
				visited[v]++;
				if(v == 99) {
					isExist = true;
					break;
				}
				
				for(int i = 0; i<100; i++) {
					if(matrix[v][i] == 1) {
						if(visited[i] < 1) {
							s.push(i);
						}
					}
				}				
			}			
		}
	}
}
