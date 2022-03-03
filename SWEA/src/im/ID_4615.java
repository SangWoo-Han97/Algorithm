package im;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * SWEA 4615. 재미있는 오셀로 게임
 */

public class ID_4615 {
	static int[][] board;
	static int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static int N, black, white;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			board = new int[N + 1][N + 1];
			board[N / 2][N / 2] = board[(N / 2) + 1][(N / 2) + 1] = 2;
			board[(N / 2) + 1][N / 2] = board[N / 2][(N / 2) + 1] = 1;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());

				board[x][y] = color;
				solution(x, y, color);
			}
			
			int blackSum = 0, whiteSum = 0;
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					if(board[i][j] == 1) blackSum++;
					else if(board[i][j] == 2) whiteSum++;
				}
			}
			black = blackSum; white = whiteSum;
			
			bw.write(String.format("#%d %d %d\n", test_case, black, white));
		}
		bw.close();
	}

	private static void solution(int x, int y, int color) {
		for (int i = 0; i < 8; i++) {
			boolean isFind = false;
			int n = 2;
			int p = x + (dir[i][0] * n), q = y + (dir[i][1] * n);
			while(p > 0 && p <= N && q > 0 && q <= N) {
				if (board[p][q] == color) {
					isFind = true;
					break;
				}
				n++;
				p = x + (dir[i][0] * n);
				q = y + (dir[i][1] * n);
			}
			if(isFind) {
				for(int j = 1; j<n; j++) {
					board[x + (dir[i][0] * j)][y + (dir[i][1] * j)] = color;
				}
			}
		}
	}

//	private static void printBoard() {
//		System.out.println();
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

}