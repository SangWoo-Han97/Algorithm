package bronze4;

import java.util.*;
import java.io.*;

public class ID_1712 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		try {
			int bep = A / (C - B) + 1;
			if (bep > 0) {
				System.out.println(bep);
			} else {
				System.out.println(-1);
			}
		} catch (ArithmeticException e) {
			System.out.println(-1);
		}
	}
}
