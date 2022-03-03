package problem_solving3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * SWEA 2115. [모의 SW 역량테스트] 벌꿀채취
 */

public class ID_2115 {
	static int[][] honey, profit;
	static int N, M, C, res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			honey = new int[N][N];
			profit = new int[N][N - M + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			res = 0;
			solution();

			bw.write(String.format("#%d %d\n", test_case, res));
		}
		bw.close();
	}

	private static void solution() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				profit[i][j] = getMaxProfit(i, j);
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<= N-M; j++) {
				System.out.print(profit[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int getMaxProfit(int x, int y) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < 1 << M; i++) {
			int cnt = 0, sum = 0;
			for (int j = 0; j < M; j++) {
				if((i & 1 << j) != 0) {
					cnt += honey[x][y+j];
					sum += honey[x][y+j] * honey[x][y+j];
				}
				if(cnt <= C) {
					max = Math.max(max, sum);
				}
			}
		}

		return max;
	}
}
