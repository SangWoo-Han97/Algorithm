package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_1247 {
	static Point company;
	static Point home;
	static Point[] points;
	
	static int N;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			points = new Point[N];
			result = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < N; i++) {
				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			perm(0, N, N);
			bw.write(String.format("#%d %d\n", test_case, result));			
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void solution() {
		int sum = Math.abs(company.x - points[0].x) + Math.abs(company.y - points[0].y);
		for(int i = 0; i<N-1; i++) {
			sum += Math.abs(points[i].x - points[i+1].x) + Math.abs(points[i].y - points[i+1].y);
		}
		sum += Math.abs(points[N-1].x - home.x) + Math.abs(points[N-1].y - home.y);
		if(sum < result) result = sum;
	}
	
	private static void perm(int depth, int n, int r) {
		if(depth == r) {
			solution();
		} else {
			for(int i = depth; i<n; i++) {
				swap(depth, i);
				perm(depth+1, n, r);
				swap(depth, i);				
			}
		}
	}
	
	private static void swap(int x, int y) {
		Point temp = points[x];
		points[x] = points[y];
		points[y] = temp;
	}
}

class Point {
	public int x, y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if(x == ((Point)obj).x && y == ((Point)obj).y) return true;
		else return false;
	}
}
