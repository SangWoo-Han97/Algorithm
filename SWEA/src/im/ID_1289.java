package im;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
	SWEA 1289. 원재의 메모리 복구하기
 */

public class ID_1289 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++ ) {
			String bit = br.readLine();
			
			int count = 0;
			int cur = 0;
			for(int i = 0; i<bit.length(); i++) {
				if(bit.charAt(i) - '0' != cur) {
					count++;
					cur ^= 1;
				}
			}
			
			bw.write(String.format("#%d %d\n", test_case, count));
		}
		bw.close();
	}
}