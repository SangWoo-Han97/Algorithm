package im;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
	SWEA 1959. 두 개의 숫자열
 */

public class ID_1959 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] Narr = new int[N];
			int[] Marr = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Narr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				Marr[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			
			if(N > M) result = solution(M, N, Marr, Narr);
			else result = solution(N, M, Narr, Marr);

			bw.write(String.format("#%d %d\n", test_case, result));
		}
		bw.close();
	}
	
	private static int solution(int N, int M, int[] Narr, int[] Marr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= M - N; i++) {
			int sum = 0;
			for(int j = i, k = 0; j <i + N; j++, k++) {
				sum += Narr[k] * Marr[j];
			}
			max = Math.max(sum, max);
		}
		return max;
	}
}