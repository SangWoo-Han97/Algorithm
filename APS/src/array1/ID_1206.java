package array1;

import java.util.*;
import java.io.*;

public class ID_1206 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {			
			int T = Integer.parseInt(bf.readLine());
			System.out.print("#" + test_case + " ");
			
			int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int sum = 0;
			for(int i = 2; i < T-2; i ++) {
				int next = Math.max(Math.max(arr[i-1], arr[i-2]), Math.max(arr[i+1], arr[i+2]));
				if(next < arr[i]) {
					sum += arr[i] - next;
				}
			}
			
			System.out.println(sum);
		}
	}
}
