package array2;

import java.util.*;
import java.io.*;

public class ID_1210 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			bf.readLine();

			int[][] ladder = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int x = 99, y = 0;
			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2) {
					y = i;
				}
			}
			x--;
			while (x > 0) {
				if (y - 1 >= 0 && ladder[x][y - 1] == 1) {
					// 왼쪽으로 이동
					while (y - 1 >= 0 && ladder[x][y - 1] == 1) {
						y--;
					}
				} else if (y + 1 <= 99 && ladder[x][y + 1] == 1) {
					// 오른쪽으로 이동
					while (y + 1 <= 99 && ladder[x][y + 1] == 1) {
						y++;
					}
				}
				x--;
			}
			System.out.print("#" + test_case + " ");
			System.out.println(y);
		}
	}
}
