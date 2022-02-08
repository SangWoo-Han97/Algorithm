package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ID_1231 {
	static int[][] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());

			// [N][0]: left child, [N][1]: right child, [N][2]: parent, [N][3]: character
			tree = new int[N + 1][4];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int cur = Integer.parseInt(st.nextToken());
				int idx = 1;
				while(st.hasMoreTokens()) {
					switch(idx) {
					case 1: 
						tree[cur][3] = st.nextToken().charAt(0); 
						break;
					case 2: 
						int left = Integer.parseInt(st.nextToken());
						tree[cur][0] = left;
						tree[left][2] = cur;
						break;
					case 3:
						int right = Integer.parseInt(st.nextToken());
						tree[cur][1] = right;
						tree[right][2] = cur;
						break;
					}					
					idx++;
				}
			}
			
			sb = new StringBuilder();
			System.out.print("#" + test_case + " ");
			inOrder(1);
			System.out.println(sb.toString());
		}
	}
	
	private static void inOrder(int node) {
		if(node == 0) return;
		inOrder(tree[node][0]);
		sb.append((char)tree[node][3]);
		inOrder(tree[node][1]);				
	}
}
