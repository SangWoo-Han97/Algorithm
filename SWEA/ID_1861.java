package problem_solving1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_1861 {
	static int[][] room;
	static boolean[][] visited;
	static int N;
	static int max = 0;
	static int min = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {				
				for (int j = 0; j < N; j++) {	
					dfs(1, i, j, room[i][j]);	// 모든 방에 대해 dfs 탐색
				}
			}
			bw.write(String.format("#%d %d %d\n", test_case, min, max));
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int depth, int x, int y, int from) {		
		for (int i = 0; i < 4; i++) {	// 상, 하, 좌, 우 탐색
			int row = x + dx[i];
			int col = y + dy[i];

			if (row >= 0 && row < N && col >= 0 && col < N) {	// 배열 범위 체크
				if (room[x][y] + 1 == room[row][col] && !visited[x][y]) {	// 현재 방 숫자보다 1 큰 경우
					dfs(depth + 1, row, col, from);	// 이동할 수 있는 
				}
			}
		}
		
		visited[x][y] = true;	// 방문 체크 배열에 현재 방에서 이동할 수 있는 횟수 저장
		if (max <= depth) {
			if(max < depth) {	// max값이 바뀌었을 경우 min은 새로 초기화
				min = Integer.MAX_VALUE;
			}
			max = depth;
			if (min > from)
				min = from;
		}
		visited[x][y] = false;
	}
}