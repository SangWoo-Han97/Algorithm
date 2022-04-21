package exhaustive_search_and_greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class ID_1244 {
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String next = st.nextToken();
			int n = Integer.parseInt(st.nextToken());			
			result = Integer.MIN_VALUE;
			char[] arr = next.toCharArray();
			if(arr.length < n) {
				n = arr.length;
			}
			dfs(0, n, arr);
			bw.write(String.format("#%d %d\n",test_case, result));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dfs(int start, int n, char[] arr) {
		if(n == 0) {
			int cur = toInt(arr);
			if(cur > result) result = cur;
			return;
		}
		
		for(int i = start; i < arr.length-1; i++) {
			for(int j = i+1; j <arr.length; j++ ) {
				char from = arr[i];
				char to = arr[j];
				
				arr[i] = to;
				arr[j] = from;
				dfs(i, n-1, arr);
				arr[i] = from;
				arr[j] = to;
			}
		}
	}
	
	private static int toInt(char[] arr) {
		int sum = 0;
		for(int i = arr.length -1, dec = 1; i >= 0; i--, dec*=10) {
			sum += (arr[i] - '0') * dec;	
		}
		return sum;
	}
}
