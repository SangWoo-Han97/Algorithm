package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_1232 {
	static int[][] tree;
	static String operator = "+-*/";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			// [N][0] = left, [N][1] = right, [N][2] = character, [N][3] = number 
			tree = new int[N+1][4];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int cur = Integer.parseInt(st.nextToken());
				int idx = 1;
				while(st.hasMoreTokens()) {
					String next = st.nextToken();
					switch(idx) {
					case 1:
						if(!operator.contains(next)) {
							tree[cur][3] = Integer.parseInt(next);
						} else {
							tree[cur][2] = next.charAt(0);
						}
						break;
					case 2:
						tree[cur][0] = Integer.parseInt(next);
						break;
					case 3:
						tree[cur][1] = Integer.parseInt(next);
						break;
					}
					idx++;
				}
			}		
			bw.write(String.format("#%d %d\n", test_case, (int)inOrder(1)));
		}	
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static double inOrder(int node) {		
		if(tree[node][2] == 0) {
			return tree[node][3];
		}
		
		if(tree[node][2] == '+') {
			return inOrder(tree[node][0]) + inOrder(tree[node][1]);
		} else if(tree[node][2] == '-') {
			return inOrder(tree[node][0]) - inOrder(tree[node][1]);
		} else if(tree[node][2] == '*') {
			return inOrder(tree[node][0]) * inOrder(tree[node][1]);
		} else {
			return inOrder(tree[node][0]) / inOrder(tree[node][1]);
		}	
	}
}
