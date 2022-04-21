package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_13300 {
	static int[][] student;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		student = new int[7][2];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			student[grade][gender]++;
		}
		
		int room = 0;
		for(int i = 1; i<=6; i++) {
			for(int j = 0; j<2; j++) {
				room += student[i][j] / K;
				if(student[i][j] % K != 0) room++;
			}
		}
		
		bw.write(String.valueOf(room));
		bw.flush();
		bw.close();
		br.close();
	}
}