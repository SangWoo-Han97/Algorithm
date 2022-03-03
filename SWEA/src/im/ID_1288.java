package im;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
	SWEA 1288. 새로운 불면증 치료법
 */

public class ID_1288 {
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			check = new boolean[10];
			
			int count = 1;
			while(true) {
				if(solution(N * count)) {
					break;
				}
				count++;
			}
			bw.write(String.format("#%d %d\n", test_case, N*count));
		}
		bw.close();
	}
	
	private static boolean solution(Integer N) {
		String arr = N.toString();
		for(int i = 0; i<arr.length(); i++) {
			check[arr.charAt(i)-'0'] = true;
		}
		return check();
	}
	
	private static boolean check() {
		for(int i = 0; i<10; i++) {
			if(!check[i]) return false;
		}
		return true;
	}
}
