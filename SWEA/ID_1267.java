package stack2;

import java.util.*;
import java.io.*;

public class ID_1267 {
	static int[][] matrix;
	static int V;
	static int E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			matrix = new int[V+1][V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = 1;
			}
			//printMatrix();
			System.out.printf("#%d %s\n", test_case, solve());			
		}
	}
	
	private static String solve() {
		StringBuilder sb = new StringBuilder();
		
		int count = V;
		
		while(count > 0) {
			for(int i = 1; i <= V; i++) {
				boolean isOpen = true;
				for(int j = 1; j <= V; j++) {
					if(matrix[j][i] == -1) {
						isOpen = false;
						break;
					}
					if(matrix[j][i] == 1) {
						isOpen = false;
						break;
					}
				}
				if(isOpen) {
					sb.append(i + " ");
					for(int j = 1; j<=V; j++) {
						if(matrix[i][j] == 1) {
							matrix[i][j] = 0;
						}
					}
					matrix[1][i] = -1;
					count--;
					break;
				}
			}
		}
		
		return sb.toString();
	}
	
	private static void printMatrix() {
		for(int i = 1; i<matrix.length; i++) {
			for(int j = 1; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
