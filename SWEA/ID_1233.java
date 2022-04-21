package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_1233 {
	static String operator = "+-*/";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int isPossible = 1;
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				
				String next = st.nextToken();
				if(operator.contains(next)) {
					if(st.countTokens() <2) {
						isPossible = 0;
						continue;
					}
				} else {
					if(st.hasMoreTokens()) {
						isPossible = 0;
					}
				}				
			}	
			bw.write(String.format("#%d %d\n", test_case, isPossible));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
