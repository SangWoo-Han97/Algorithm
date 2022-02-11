package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_2578 {
	static int[][] board;
	static int[] dir;
	static boolean[][] bingo;
	static final int N = 5;
	static final int M = 25;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		dir = new int[M];
		bingo = new boolean[N][N];

		for (int i = 0; i < M; i++) {
			if (i % 5 == 0)
				st = new StringTokenizer(br.readLine());
			dir[Integer.parseInt(st.nextToken())-1] = i;
		}

		int count = 0;
		for (int i = 0; i < N * 5; i++) {
			if (i % 5 == 0)
				st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			idx--;
			count++;
			bingo[dir[idx] / N][dir[idx] % N] = true;
			if (checkBingo()) {
				break;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean checkBingo() {
		int bingoCount = 0;
		int xCount = 0, yCount = 0;
		int rCross = 0, lCross = 0;
		for (int i = 0; i < 5; i++) {
			xCount = 0;
			yCount = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == true)
					xCount++;
				if (bingo[j][i] == true)
					yCount++;
				if (i == j) {
					if (bingo[i][j] == true)
						rCross++;
				}
				if (i == N - j - 1) {
					if (bingo[i][j] == true)
						lCross++;
				}
			}
			if (xCount == 5)
				bingoCount++;
			if (yCount == 5)
				bingoCount++;
			if (rCross == 5)
				bingoCount++;
			if (lCross == 5)
				bingoCount++;
		}

		if (bingoCount >= 3)
			return true;
		else
			return false;
	}
}
