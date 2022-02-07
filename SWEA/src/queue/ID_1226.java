package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ID_1226 {

	static int[][] matrix;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			matrix = new int[16][16];
			visited = new boolean[16][16];

			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				for (int j = 0; j < 16; j++) {
					matrix[i][j] = line.charAt(j) - '0';		
				}
			}
			
			System.out.println("#" + test_case + " " + bfs(new Point(1, 1)));			
		}
	}
	
	public static int bfs(Point p) {
		Queue<Point> q = new LinkedList<Point>();
		int[] dir = {-1,0,0,1,1,0,0,-1};
		
		q.add(p);
		visited[p.x][p.y] = true;
		
		while(!q.isEmpty()) {
			Point t = q.poll();

			for(int i = 0; i<8; i+=2) {
				if(matrix[t.x + dir[i]][t.y + dir[i+1]] != 1 && !visited[t.x + dir[i]][t.y + dir[i+1]]) {
					if(matrix[t.x + dir[i]][t.y + dir[i+1]] == 3) {
						return 1;
					}
					q.add(new Point(t.x + dir[i], t.y + dir[i+1]));
					visited[t.x + dir[i]][t.y + dir[i+1]] = true;
				}
			}
		}				
		return 0;
	}	
}

class Point {
	int x; int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
