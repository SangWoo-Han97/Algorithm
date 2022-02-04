package stack1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ID_1219_1 {
	static int[][] matrix;
	static int[] visited;
	static boolean isExist = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());

			matrix = new int[100][100];
			visited = new int[100];
			isExist = false;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = 1;
			}

			DFSr(0);
			System.out.print("#" + test_case + " ");
			if (isExist) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	private static void DFSr(int v) {
		visited[v]++;
		if (v == 99) {
			isExist = true;
			return;
		}
		for (int i = 0; i < 100; i++) {
			if (matrix[v][i] == 1) {
				if (visited[i] < 1) {
					DFSr(i);
				}
			}
		}
	}
}
