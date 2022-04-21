package array2;

import java.util.*;
import java.io.*;

public class ID_1220 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();

			int[][] square = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					square[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int deadlock = 0;
			int prev = -1;		
			
			for (int i = 0; i < 100; i++) {
				boolean isFirst = true;
				
				for (int j = 0; j < 100; j++) {
					if(square[j][i] == 2) {	// S극일때
						if(isFirst) {
							continue;
						}
						if(prev == 2) {	// 이전 값과 같으면 skip
							continue;
						}
						if(prev == 1) {	// 이전 값이 N이면 교착상태 1 증가
							deadlock++;
							prev = 2;
						}
					} else if(square[j][i] == 1) {	// N극일때
						if(isFirst) {
							prev = 1;
							isFirst = false;
						}
						if(prev == 1) {
							continue; // 이전 것과 같으면 skip
						}
						prev = 1;
					}
				}
			}
			System.out.print("#" + test_case + " ");
			System.out.println(deadlock);
		}
	}
}
