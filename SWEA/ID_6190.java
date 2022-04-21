package im;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
	SWEA 6190. 정곤이의 단조 증가하는 수
 */

public class ID_6190 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = Integer.MIN_VALUE;
			for(int i = 0; i<N-1; i++) {
				for(int j = i+1; j<N; j++) {
					int num = arr[i] * arr[j];
					if(max < num) {
						if(isDanso(num)) 
							max = num;
					}
				}
			}
			if(max == Integer.MIN_VALUE) max = -1;
			bw.write(String.format("#%d %d\n", test_case, max));
		}
		bw.close();
	}
	
	private static boolean isDanso(int n) {
		String num = Integer.toString(n);
		
		for(int i = 0; i<num.length() - 1; i++) {
			if(num.charAt(i) > num.charAt(i+1)) return false;
		}		
		return true;
	}
}