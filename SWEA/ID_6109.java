package problem_solving1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_6109 {
	static int[][] board;
	static int N;
	static final int UP = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	static final int RIGHT = 4;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();

			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solution(dir);
			
			bw.write(String.format("#%d\n", test_case));
			for(int i = 0; i<N ;i++) {
				for(int j = 0; j<N; j++) {
					bw.write(String.format("%d ", board[i][j]));
				}
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void solution(String dir) {
		if(dir.equals("up")) {
			removeZero(UP);
			for(int i = 0; i<N; i++) {
				for(int j = 1; j<N; j++) {
					if(board[j][i] == 0) continue;
					if(board[j][i] == board[j-1][i]) {
						move(UP, i, j);
						board[j-1][i] *= 2;
					}
				}
			}
		} else if(dir.equals("down")) {
			removeZero(DOWN);
			for(int i = 0; i<N; i++) {
				for(int j = N-2; j>=0; j--) {
					if(board[j][i] == 0) continue;
					if(board[j][i] == board[j+1][i]) {
						move(DOWN, i, j);
						board[j+1][i] *= 2;
					}
				}
			}			
		} else if(dir.equals("left")) {
			removeZero(LEFT);
			for(int i = 0; i<N; i++) {
				for(int j = 1; j<N; j++) {
					if(board[i][j] == 0) continue;
					if(board[i][j] == board[i][j-1]) {
						move(LEFT, i, j);
						board[i][j-1] *= 2;
					}
				}
			}			
		} else if(dir.equals("right")) {
			removeZero(RIGHT);
			for(int i = 0; i<N; i++) {
				for(int j = N-2; j>=0; j--) {
					if(board[i][j] == 0) continue;
					if(board[i][j] == board[i][j+1]) {
						move(RIGHT, i, j);
						board[i][j+1] *= 2;
					}
				}
			}			
		}
	}
	
	static private void removeZero(int dir) {
		// 주어진 방향 반대에서부터 차례로 0제거
		switch(dir) {
		case UP:
			for(int i = 0; i<N; i++) {
				boolean start = false;
				for(int j = N-1; j>=0; j--) {
					if(board[j][i] != 0) start = true;
					if(start) 
						if(board[j][i] == 0) 
							move(UP, i, j);
				}
			} break;			
		case DOWN:
			for(int i = 0; i<N; i++) {
				boolean start = false;
				for(int j = 0; j<N; j++) {
					if(board[j][i] != 0) start = true;
					if(start) 
						if(board[j][i] == 0) 
							move(DOWN,i, j);
				}
			} break;			
		case LEFT:
			for(int i = 0; i<N; i++) {
				boolean start = false;
				for(int j = N-1; j>=0; j--) {
					if(board[i][j] != 0) start = true;
					if(start) 
						if(board[i][j] == 0) 
							move(LEFT, i, j);			
				}
			} break;	
		case RIGHT:
			for(int i = 0; i<N; i++) {
				boolean start = false;
				for(int j = 0; j<N; j++) {
					if(board[j][i] != 0) start = true;
					if(start) 
						if(board[i][j] == 0) 
							move(RIGHT,i, j);		
				}
			} break;			
		}
	}
	
	static private void move(int dir, int x, int y) {
		switch(dir) {
		case UP:
			for(int j = y; j < N-1; j++) 
				board[j][x] = board[j+1][x];
			board[N-1][x] = 0; break;			
		case DOWN:
			for(int j = y; j >0; j--) 
				board[j][x] = board[j-1][x];
			board[0][x] = 0; break;			
		case LEFT:
			for(int j = y; j < N-1; j++) 
				board[x][j] = board[x][j+1];
			board[x][N-1] = 0;	break;
		case RIGHT:
			for(int j = y; j >0; j--) 
				board[x][j] = board[x][j-1];
			board[x][0] = 0; break;	
		}
	}
}
