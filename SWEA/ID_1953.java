package problem_solving4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
	SWEA 1953. [모의 SW 역량테스트] 탈주범 검거
 */

public class ID_1953 {
	static int[][] matrix;
	static boolean[][] visited;
	static int N, M, R, C, L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			matrix = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			bw.write(String.format("#%d %d\n", test_case, count()));
		}
		bw.close();
	}

	private static void bfs() {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(R, C, 1));

		Point p = null;
		while (!Q.isEmpty()) {
			p = Q.poll();
			visited[p.x][p.y] = true; 
			//System.out.println(String.format("x: %d, y: %d, matrix[x][y]: %d, step: %d", p.x, p.y, matrix[p.x][p.y], p.step));
			if(p.step >= L) continue;

			switch (matrix[p.x][p.y]) {
			case 1:
				type1(p, Q);
				break;
			case 2:
				type2(p, Q);
				break;
			case 3:
				type3(p, Q);
				break;
			case 4:
				type4(p, Q);
				break;
			case 5:
				type5(p, Q);
				break;
			case 6:
				type6(p, Q);
				break;
			case 7:
				type7(p, Q);
				break;
			}
		}
	}

	private static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					cnt++;
			}
		}
		return cnt;
	}

	private static void type1(Point p, Queue<Point> Q) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		for (int i = 0; i < dx.length; i++) {
			int x = p.x + dx[i];
			int y = p.y + dy[i];
			if (x >= 0 && x < N && y >= 0 && y < M) {
				if(visited[x][y]) continue;
				switch(i) {
				case 0:
					if(matrix[x][y] == 1 || matrix[x][y] == 2 || matrix[x][y] == 5 || matrix[x][y] == 6)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				case 1:
					if(matrix[x][y] == 1 || matrix[x][y] == 3 || matrix[x][y] == 6 || matrix[x][y] == 7)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				case 2:
					if(matrix[x][y] == 1 || matrix[x][y] == 2 || matrix[x][y] == 4 || matrix[x][y] == 7)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				case 3:
					if(matrix[x][y] == 1 || matrix[x][y] == 3 || matrix[x][y] == 4 || matrix[x][y] == 5)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				}			
			}
		}
	}

	private static void type2(Point p, Queue<Point> Q) {
		int[] dx = { -1, 1 };
		int[] dy = { 0, 0 };
		for (int i = 0; i < dx.length; i++) {
			int x = p.x + dx[i];
			int y = p.y + dy[i];
			if (x >= 0 && x < N && y >= 0 && y < M) {
				if(visited[x][y]) continue;
				switch(i) {
				case 0:
					if(matrix[x][y] == 2 || matrix[x][y] == 1 || matrix[x][y] == 5 || matrix[x][y] == 6)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				case 1:
					if(matrix[x][y] == 2 || matrix[x][y] == 1 || matrix[x][y] == 4 || matrix[x][y] == 7)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				}	
			}
		}
	}

	private static void type3(Point p, Queue<Point> Q) {
		int[] dx = { 0, 0 };
		int[] dy = { 1, -1 };
		for (int i = 0; i < dx.length; i++) {
			int x = p.x + dx[i];
			int y = p.y + dy[i];
			if (x >= 0 && x < N && y >= 0 && y < M) {
				if(visited[x][y]) continue;
				switch(i) {
				case 0:
					if(matrix[x][y] == 3 || matrix[x][y] == 1 || matrix[x][y] == 6 || matrix[x][y] == 7) {
						Q.offer(new Point(x, y, p.step + 1));
					}
					break;
				case 1:
					if(matrix[x][y] == 3 || matrix[x][y] == 1 || matrix[x][y] == 4 || matrix[x][y] == 5)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				}	
			}
		}
	}

	private static void type4(Point p, Queue<Point> Q) {
		int[] dx = { -1, 0 };
		int[] dy = { 0, 1 };
		for (int i = 0; i < dx.length; i++) {
			int x = p.x + dx[i];
			int y = p.y + dy[i];
			if (x >= 0 && x < N && y >= 0 && y < M) {
				if(visited[x][y]) continue;
				switch(i) {
				case 0:
					if(matrix[x][y] == 1 || matrix[x][y] == 2 || matrix[x][y] == 5 || matrix[x][y] == 6)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				case 1:
					if(matrix[x][y] == 1 || matrix[x][y] == 3 || matrix[x][y] == 6 || matrix[x][y] == 7)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				}	
			}
		}
	}

	private static void type5(Point p, Queue<Point> Q) {
		int[] dx = { 0, 1 };
		int[] dy = { 1, 0 };
		for (int i = 0; i < dx.length; i++) {
			int x = p.x + dx[i];
			int y = p.y + dy[i];
			if (x >= 0 && x < N && y >= 0 && y < M) {
				if(visited[x][y]) continue;
				switch(i) {
				case 0:
					if(matrix[x][y] == 1 || matrix[x][y] == 3 || matrix[x][y] == 6 || matrix[x][y] == 7)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				case 1:
					if(matrix[x][y] == 1 || matrix[x][y] == 2 || matrix[x][y] == 4 || matrix[x][y] == 7)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				}	
			}
		}
	}

	private static void type6(Point p, Queue<Point> Q) {
		int[] dx = { 1, 0 };
		int[] dy = { 0, -1 };
		for (int i = 0; i < dx.length; i++) {
			int x = p.x + dx[i];
			int y = p.y + dy[i];
			if (x >= 0 && x < N && y >= 0 && y < M) {
				if(visited[x][y]) continue;
				switch(i) {
				case 0:
					if(matrix[x][y] == 1 || matrix[x][y] == 2 || matrix[x][y] == 4 || matrix[x][y] == 7)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				case 1:
					if(matrix[x][y] == 1 || matrix[x][y] == 3 || matrix[x][y] == 4 || matrix[x][y] == 5)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				}
			}
		}
	}

	private static void type7(Point p, Queue<Point> Q) {
		int[] dx = { 0, -1 };
		int[] dy = { -1, 0 };
		for (int i = 0; i < dx.length; i++) {
			int x = p.x + dx[i];
			int y = p.y + dy[i];
			if (x >= 0 && x < N && y >= 0 && y < M) {
				if(visited[x][y]) continue;
				switch(i) {
				case 0:
					if(matrix[x][y] == 1 || matrix[x][y] == 3 || matrix[x][y] == 4 || matrix[x][y] == 5)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				case 1:
					if(matrix[x][y] == 1 || matrix[x][y] == 2 || matrix[x][y] == 5 || matrix[x][y] == 6)
						Q.offer(new Point(x, y, p.step + 1));
					break;
				}
			}
		}
	}
}

class Point {
	int x, y, step;

	public Point(int x, int y, int step) {
		this.x = x;
		this.y = y;
		this.step = step;
	}
}
