package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
	input : 
13
1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
*/


public class TreeEx {
	static int[][] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new int[N+1][2];		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N-1; i++) {
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			if(tree[parent][0] != 0) tree[parent][1] = child;
			else tree[parent][0] = child;
		}
		
		System.out.print("preOrder: ");
		preOrder(1);
		System.out.println();
		
		System.out.print("inOrder: ");
		inOrder(1);
		System.out.println();
		
		System.out.print("postOrder: ");
		postOrder(1);
		System.out.println();
	}
	
	private static void preOrder(int node) {
		if(node == 0) return;
		System.out.print(node + " ");
		preOrder(tree[node][0]);
		preOrder(tree[node][1]);
	}
	
	private static void inOrder(int node) {
		if(node == 0) return;
		inOrder(tree[node][0]);
		System.out.print(node + " ");
		inOrder(tree[node][1]);
	}
	
	private static void postOrder(int node) {
		if(node == 0) return;
		postOrder(tree[node][0]);
		postOrder(tree[node][1]);
		System.out.print(node + " ");
	}
}
