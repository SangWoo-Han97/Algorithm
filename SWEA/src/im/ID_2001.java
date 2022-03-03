package im;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * SWEA 2001. 파리 퇴치
 */

public class ID_2001 {
	static int[][] board;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			board = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bw.write(String.format("#%d %d\n", test_case, solution()));
		}
		bw.close();
	}

	private static int solution() {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= N - M; i++) {
			for (int j = 0; j<= N-M; j++) {
				int sum = 0;
				for(int k = i; k < i + M; k++ ) {
					for(int h = j; h < j + M; h++) {
						sum += board[k][h];
					}
				}
				max = Math.max(max, sum);
			}
		}

		return max;
	}
}