package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ID_2491 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0 ;i<N; i++) {
			arr[i]  = Integer.parseInt(st.nextToken());
		}
		
		int asc = 1;
		int max = 1;
		for(int i = 0; i<N-1; i++) {
			if(arr[i] <= arr[i+1]) asc++;
			else asc = 1;
			max = Math.max(max, asc);
		}
		
		int desc = 1;
		for(int i = 0; i<N-1; i++) {
			if(arr[i] >= arr[i+1]) desc++;
			else desc = 1;
			max = Math.max(max, desc);
		}
		System.out.println(max);
	}
}
