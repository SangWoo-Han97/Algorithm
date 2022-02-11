package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_10157 {
	static int[][] seat;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int C, R, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());

		if (C * R < N) {
			System.out.println(0);
			return;
		}

		seat = new int[C][R];
		int x = 0, y = 0, dir = 0;
		for (int i = 1; i <= N; i++) {
			seat[x][y] = i;				
			if(!(x + dx[dir] >= 0 && x + dx[dir] < C && y + dy[dir] >= 0 && y + dy[dir]< R
					&& seat[x + dx[dir]][y + dy[dir]] == 0)) {
				dir ++;
				if(dir == 4) dir = 0;
			}			
			x += dx[dir]; y += dy[dir];
		}
		x -= dx[dir]; y -= dy[dir];
		
		bw.write(String.format("%d %d\n", x + 1, y + 1));
		bw.flush();
		bw.close();
		br.close();
	}
}
