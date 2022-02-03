package example;

/**
 * 부분집합 합 문제 구현하기
 * 
 * 10개의 정수를 입력 받아 부분집합의 합이 0이 되는 것이 존재하는 지를 계산
 */

public class Subset {
	public static void main(String[] args) {
		int arr[] = { -1, 3, -9, 6, 7, -6, 1, 5, 4, -2 };
		int sum;
		int count = 0;

		for (int i = 1; i < (1 << 10); i++) {
			// i가 1부터 시작하는 이유는?
			// -> 공집합은 제외 (공집합일 경우 합이 0임)
			sum = 0;
			for (int j = 0; j < 10; j++) {
				if ((i & (1 << j)) != 0) {
					sum += arr[j];
				}
			}

			if (sum == 0) {
				System.out.printf("[ %d ] ", ++count);
				for (int j = 0; j < 10; j++) {
					if ((i & (1 << j)) != 0) {
						System.out.printf("%d ", arr[j]);
					}
				}
				System.out.println();
			}
		}
	}
}
