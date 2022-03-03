package im;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * SWEA 2805. 농작물 수확하기
 */

public class ID_2805 {
	static int[][] board;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = line.charAt(j) - '0';
				}
			}

			bw.write(String.format("#%d %d\n", test_case, solution()));
		}
		bw.close();
	}

	private static int solution() {
		int sum = 0;

		if (N == 1)
			return board[0][0];

		int center = N / 2;
		for (int i = 0; i < N / 2; i++) {
			for (int j = center - i; j<= center + i; j++) {
				sum += board[i][j];
			}
		}
		
		for(int i = 0; i<N; i++) {
			sum += board[center][i];
		}
		
		for (int i = N-1, k = 0; i > N / 2; i--, k++) {
			for (int j = center - k; j<= center + k; j++) {
				sum += board[i][j];
			}
		}		

		return sum;
	}
}
