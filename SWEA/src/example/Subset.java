package example;

/**
 * 부분집합 합 문제 구현하기
 * 
 * 10개의 정수를 입력 받아 부분집합의 합이 0이 되는 것이 존재하는 지를 계산
 */

public class Subset {
	static int N = 5;
	static int[] arr = { 1, 2, 3, 4, 5 };

	public static void main(String[] args) {
		for (int i = 1; i < (1 << N); i++) {
			for(int j = 0; j<N; j++) {
				if((i & (1 << j)) != 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
