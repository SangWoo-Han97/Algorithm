package im;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * SWEA 6485. 삼성시의 버스 노선
 */

public class ID_6485 {
	static int[] station = new int[5001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init();
			int N = Integer.parseInt(br.readLine());			

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for(int j = a; j<=b; j++) {
					station[j]++;
				}
			}
			
			bw.write(String.format("#%d ", test_case));
			int P = Integer.parseInt(br.readLine());
			for(int i = 0; i < P; i++) {
				int c = Integer.parseInt(br.readLine());
				bw.write(String.format("%d ", station[c]));
			}
			bw.newLine();
		}
		bw.close();
	}
	public static void init() {
		for(int i = 1; i<5001; i++) {
			station[i] = 0;
		}
	}
}


//public static void main(String[] args) throws Exception {
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	StringTokenizer st = null;
//
//	int T = Integer.parseInt(br.readLine());
//	for (int test_case = 1; test_case <= T; test_case++) {
//		int N = Integer.parseInt(br.readLine());			
//		List<Set<Integer>> lines = new ArrayList<>();
//
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			Set<Integer> line = new HashSet<>(b-a+1);
//			for(int j = a; j<=b; j++) {
//				line.add(j);
//			}
//			lines.add(line);
//		}
//		
//		bw.write(String.format("#%d ", test_case));
//		int P = Integer.parseInt(br.readLine());
//		for(int i = 0; i < P; i++) {
//			int c = Integer.parseInt(br.readLine());
//			int sum = 0;
//			for(Set<Integer> line : lines) {
//				if(line.contains(c)) sum++;
//			}
//			bw.write(String.format("%d ", sum));
//		}
//		bw.newLine();
//	}
//	bw.close();
//}