package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ID_2309 {
	static int[] origin = new int[9];
	static int[] result = new int[7];
	static int N = 9, R = 7;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			origin[i] = Integer.parseInt(br.readLine());
		}		
		comb(N, R);
	}
	
	private static void comb(int n, int r) {
		if(r==0) calculate();
		else if(n<r) return;
		else {
			result[r-1] = origin[n-1];
			comb(n-1, r-1);
			comb(n-1, r);			
		}		
	}
	
	private static void calculate() {
		int sum = 0;
		for(int i = 0; i<R; i++) {
			sum += result[i];
		}
		if(sum == 100) {
			Arrays.sort(result);
			printArr();
			System.exit(0);
		}
	}
	
	private static void printArr() {
		for(int i = 0; i<R; i++) {
			System.out.println(result[i]);
		}
	}
}