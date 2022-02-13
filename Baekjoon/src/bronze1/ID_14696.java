package bronze1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_14696 {
	static int[] A;
	static int[] B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			A = new int[5]; B = new int[5];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j<n; j++) {
				A[Integer.parseInt(st.nextToken())] ++;
			}
					
			st = new StringTokenizer(br.readLine());			
			n = Integer.parseInt(st.nextToken());
			for(int j = 0; j<n; j++) {
				B[Integer.parseInt(st.nextToken())] ++;
			}
			
			bw.write(solution());
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();		
	}
	
	private static String solution() {
		for(int i = 4; i>0; i--) {
			if(A[i] > B[i]) return "A";
			else if(A[i] < B[i]) return "B";
		}
		
		return "D";
	}
}