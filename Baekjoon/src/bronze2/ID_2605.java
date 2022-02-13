package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ID_2605 {
	static int N;
	static int[] origin;
	static LinkedList<Integer> result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		result = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			result.add(i-Integer.parseInt(st.nextToken()), i+1);
		}	
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			sb.append(result.get(i) + " ");
		}
		System.out.println(sb.toString());
	}
}
