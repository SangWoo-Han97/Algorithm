package stack1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ID_1217 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 0; test_case < 10; test_case++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
					
			System.out.println("#" + test_case + " " + power(N, M));			
		}
	}
	
	public static int power(int N, int M) {
		if(M == 0) {
			return 1;
		}
		if(M == 1) {
			return N;
		} else {
			return power(N, M-1) * N;
		}
	}
}
