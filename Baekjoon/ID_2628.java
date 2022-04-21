package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ID_2628 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());

		int[][] arr = { new int[M + 1], new int[N + 1] };

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		int nMax = 0;
		int prev = 0;
		for (int i = 1; i <= M; i++) {
			if (arr[0][i] == 1 || i == M) {
				int cur = i - prev;
				if (nMax < cur)
					nMax = cur;
				prev = i;
			}
		}

		int mMax = 0;
		prev = 0;
		for (int i = 0; i <= N; i++) {
			if (arr[1][i] == 1 || i == N) {
				int temp = i - prev;
				if (mMax < temp)
					mMax = temp;
				prev = i;
			}
		}
		System.out.println(nMax * mMax);		
		br.close();
	}
}
