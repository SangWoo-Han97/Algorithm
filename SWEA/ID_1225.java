package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ID_1225 {
	
	static int[] pw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());

			pw = new int[8];
			for (int i = 0; i < 8; i++) {
				pw[i] = Integer.parseInt(st.nextToken());
			}

			int cycle = 1;
			int cur = 0;
			
			while (true) {
				if (pw[cur] - cycle <= 0) {
					pw[cur++] = 0;
					break;
				}

				pw[cur++] -= cycle++;

				if (cycle > 5) {
					cycle = 1;
				}
				if (cur > 7) {
					cur = 0;
				}
			}

			System.out.println("#" + test_case + " " + printQ(cur));
		}
	}
	
	public static String printQ(int cur) {
		StringBuilder sb = new StringBuilder();
		for(int i = cur; i < 8; i++) {
			sb.append(pw[i] + " ");
		}
		for(int i = 0; i<cur; i++) {
			sb.append(pw[i] + " ");
		}
		return sb.toString();
	}
}
