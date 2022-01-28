package string;

import java.io.*;
import java.util.Arrays;

public class ID_1216_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			char[][] square = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				for (int j = 0; j < 100; j++) {
					square[i][j] = line.charAt(j);
				}
			}
			
			int max = 1;			
			max = Math.max(max, getMaxPalindrome(square));
					
			makeTransposeMatrix(square);	// 전치 행렬로 만들기
			
			max = Math.max(max, getMaxPalindrome(square));
			
			System.out.print("#" + test_case + " ");
			System.out.println(max);
		}
	}
	
	public static int getMaxPalindrome(char[][] square) {
		int max = 1;
		for(int i = 0; i < 100; i++) {
			int prev = 1;
			for(int j = 3; j <= 100; j++) {	//길이 3 ~ 100 까지 회문 조사
				if(!checkPalindrome(j, square[i])) {	// 회문 안나오면 조사 종료
					max = Math.max(prev, max);
					break;
				}
				prev = j;
			}
						
		}
		return max;
	}
	
	public static boolean checkPalindrome(int N, char[] line) {	// N길이의 회문 찾으면 true 리턴
		for (int i = 0; i < 100 - N + 1; i++) {
			int count = 0;
			for (int j = i, k = 0; j < i + N / 2; j++, k++) {
				if (line[j] == line[i + N - 1 - k]) {
					count++;
				} else {
					break;
				}
			}
			if(count == N/2) {
				return true;
			}
		}
		return false;
	}

	public static void makeTransposeMatrix(char[][] arr) {	// 전치 행렬로 만들기
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (i < j) {
					char temp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = temp;
				}
			}
		}
	}
}
