package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_10163 {
	static int[][] board;
	static int[] result;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[1002][1002];
		result = new int[N+1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + dx; j++) {
				for (int k = y; k < y + dy; k++) {
					board[j][k] = i;
				}
			}
			//printBoard(20);
		}
		
		for(int i = 0; i<1002; i++) {
			for(int j = 0; j<1002; j++) {
				if(board[i][j] != 0) result[board[i][j]]++;
			}
		}
		
		for(int i = 1; i<=N; i++) {
			bw.write(String.valueOf(result[i]));
			bw.newLine();
		}		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void printBoard(int n) {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}