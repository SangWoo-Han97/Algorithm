package array1;

import java.util.*;
import java.io.*;

public class ID_1204 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");
			
			bf.readLine();

			int[] score = new int[101];

			StringTokenizer st = new StringTokenizer(bf.readLine());			

			for (int i = 0; i < 1000; i++) {	// 해당 
				score[Integer.parseInt(st.nextToken())]++;
			}

			int max = -1;
			int max_idx = 0;
			for (int i = 0; i < 101; i++) {
				if (max <= score[i]) {
					max = score[i];
					max_idx = i;
				}
			}
			System.out.println(max_idx);
		}
	}
}
