package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ID_1248 {
	static int[][] tree;
	static int V, E, n1, n2;
	static int parent, size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			size = 0;
			tree = new int[V+1][3]; // 0 : left, 1 : right, 2 : parent
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(tree[from][0] == 0) {
					tree[from][0] = to;
				} else {
					tree[from][1] = to;
				}				
				tree[to][2] = from;
			}
			
			solution(n1, n2);
			bw.write(String.format("#%d %d %d\n", test_case, parent, size));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void solution(int n1, int n2) {
		Set<Integer> parents = new HashSet<>(V);
		
		int cur = n1;
		while(true) {
			if(tree[cur][2] == 0) break;
			parents.add(tree[cur][2]);
			cur = tree[cur][2];
		}
		
		cur = n2;
		while(true) {
			if(parents.contains(tree[cur][2])) {
				break;
			} else {
				cur = tree[cur][2];
			}
		}
		
		parent = tree[cur][2];	
		pre(parent);
	}
	
	private static void pre(int cur) {
		if(cur != 0) {
			size++;
			pre(tree[cur][0]);
			pre(tree[cur][1]);
		}		
	}	
}