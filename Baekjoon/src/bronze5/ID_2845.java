package bronze5;

import java.io.*;
import java.util.StringTokenizer;

public class ID_2845 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int sum = L * P;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<5; i++ ) {
			int temp = Integer.parseInt(st.nextToken());
			System.out.print(temp - sum + " ");
		}		
	}
}
