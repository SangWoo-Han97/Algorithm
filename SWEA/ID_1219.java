package stack1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ID_1219 {
	static int[] arr;
	static int[] arr2;
	static boolean isExist = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());

			arr = new int[100];
			arr2 = new int[100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (arr[from] == 0) {
					arr[from] = to;
				} else {
					arr2[from] = to;
				}
			}
			isExist = false;
			dfs(0);

			System.out.print("#" + test_case + " ");
			if (isExist) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	private static void dfs(int from) {
		if (from == 99) {
			isExist = true;
			return;
		}
		if (arr[from] != 0)
			dfs(arr[from]);
		if (arr2[from] != 0)
			dfs(arr2[from]);
	}
}
