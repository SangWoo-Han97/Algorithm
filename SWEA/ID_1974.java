package im;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
	SWEA 1974. 스도쿠 검증
 */

public class ID_1974 {
	static int[][] sdk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sdk = new int[9][9];

			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					sdk[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bw.write(String.format("#%d %d\n", test_case, check()));
		}
		bw.close();
	}

	private static int check() {
		int[] check = new int[10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (check[sdk[i][j]] >= 1)
					return 0;
				check[sdk[i][j]]++;
			}
			init(check);
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (check[sdk[j][i]] >= 1)
					return 0;
				check[sdk[j][i]]++;
			}
			init(check);
		}
		
		int[][] point = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};		
		for (int i = 0; i<9; i++) {
			for(int j = point[i][0]; j < point[i][0] + 3; j++) {
				for(int k = point[i][1]; k < point[i][1] + 3; k++) {
					if (check[sdk[j][k]] >= 1)
						return 0;
					check[sdk[j][k]]++;
				}
			}
			init(check);
		}
		return 1;
	}

	private static void init(int[] check) {
		for (int i = 1; i <= 9; i++) {
			check[i] = 0;
		}
	}
}