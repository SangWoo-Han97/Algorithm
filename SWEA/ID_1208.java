package array1;

import java.util.*;
import java.io.*;

public class ID_1208 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {			
			int num = Integer.parseInt(bf.readLine());
			
			int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int i = 0; i < num; i++) {
				int max = 0, max_idx = 0;
				int min = 101, min_idx = 0;
				
				for(int j = 0; j < 100; j++) {
					if(arr[j] > max) {
						max = arr[j];
						max_idx = j;
					}
					if(arr[j] < min) {
						min = arr[j];
						min_idx = j;
					}
				}				
				if(max - min < 2) {
					break;
				}				
				arr[max_idx]--;
				arr[min_idx]++;
			}
			int max = 0, min = 101;
			
			for(int j = 0; j < 100; j++) {
				if(arr[j] > max) {
					max = arr[j];
				}
				if(arr[j] < min) {
					min = arr[j];
				}
			}	
			System.out.print("#" + test_case + " ");
			System.out.println(max - min);			
		}
	}
}
