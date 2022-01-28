package string;

import java.io.*;

public class ID_1215 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[][] square = new char[8][8];

			for (int i = 0; i < 8; i++) {
				String line = br.readLine();
				for (int j = 0; j < 8; j++) {
					square[i][j] = line.charAt(j);
				}
			}

			int sum = 0;
			for (int i = 0; i < 8; i++) {
				sum += checkPalindrome(N, square[i]);
			}
			
			makeTransposeMatrix(square);	// 전치 행렬로 만들기
			
			for (int i = 0; i < 8; i++) {
				sum += checkPalindrome(N, square[i]);
			}

			System.out.print("#" + test_case + " ");
			System.out.println(sum);
		}
	}

	public static int checkPalindrome(int N, char[] line) {
		if (N == 1) return 8;
		
		int count = 0;
		for (int i = 0; i < 8 - N + 1; i++) {
			boolean isPalindrome = true;
			for (int j = i, k = 0; j < i + N / 2; j++, k++) {
				if (line[j] != line[i + N - 1 - k]) {
					isPalindrome = false;
					break;
				}
			}
			if (isPalindrome) {
				count++;
			}
		}
		return count;
	}

	public static void makeTransposeMatrix(char[][] arr) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i < j) {
					char temp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = temp;
				}
			}
		}
	}
}
