package bronze5;

import java.util.*;
import java.io.*;

public class ID_1550 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int sum = 0;
		
		for(int i = 0; i<5; i++) {
			int n = Integer.parseInt(st.nextToken());
			sum += (n * n);
		}
		
		System.out.println(sum % 10);		
	}
}
