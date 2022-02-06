package bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ID_2669 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] matrix = new int[101][101];
		
		for(int i = 0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());
			
			for(int j = leftY; j<rightY; j++) {
				for(int k = leftX; k<rightX; k++) {
					matrix[j][k]++;
				}
			}
		}
		
		int sum = 0;
		for(int i = 1; i<=100; i++) {
			for(int j = 1; j<=100; j++) {
				if(matrix[i][j] != 0) {
					sum++;
				}
			}
		}
		
		System.out.println(sum);
	}

}
