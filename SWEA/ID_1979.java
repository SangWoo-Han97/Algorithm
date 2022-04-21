package im;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
	SWEA 1979. 어디에 단어가 들어갈 수 있을까
 */

public class ID_1979 {
	static int[][] world;
	static int N;
	static int K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			world = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					world[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bw.write(String.format("#%d %d\n", test_case, solution()));			
		}
		bw.close();
	}
	
	private static int solution() {
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			int count = 0;
			int status = 0;
			
			for(int j = 0; j<N; j++) {
				if(world[i][j] == 0) {
					if(status == 1) {
						if(count == K) sum++;
						status = 0;
						count = 0;
					}					
				} else if(world[i][j] == 1) {
					count++;
					if(j == N-1 && status == 1) {
						if(count == K) sum++;
					}
					if(status == 0) status = 1;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			int count = 0;
			int status = 0;
			
			for(int j = 0; j<N; j++) {
				if(world[j][i] == 0) {
					if(status == 1) {
						if(count == K) sum++;
						status = 0;
						count = 0;
					}					
				} else if(world[j][i] == 1) {
					count++;
					if(j == N-1 && status == 1) {
						if(count == K) sum++;
					}
					if(status == 0) status = 1;
				}
			}
		}			
		return sum;
	}
}