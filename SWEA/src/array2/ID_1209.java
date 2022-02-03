package array2;

import java.util.*;
import java.io.*;

public class ID_1209 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			bf.readLine();

			int[] sum = new int[202];

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 100; j++) {
					int value = Integer.parseInt(st.nextToken());

					sum[i] += value; // 각 행의 합
					sum[j+100] += value;	// 각 열의 합
					if(j==i)
					if (i == j)
						sum[200] += value; // 오른쪽 방향 대각선의 합
					if (99 - j == i)
						sum[201] += value; // 왼쪽 방향 대각선의 합
				}
			}
			
			int max = Integer.MIN_VALUE;
			
			for(int i = 0; i<202; i++) {
				if(max < sum[i])
					max = sum[i];
			}

			System.out.print("#" + test_case + " ");
			System.out.println(max);
		}
	}
}
