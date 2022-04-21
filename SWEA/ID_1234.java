package stack2;

import java.util.*;
import java.io.*;

public class ID_1234 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String pw = st.nextToken();
			
			Stack<Character> s = new Stack<>();
			
			for(int i = 0; i < N; i++) {
				char c = pw.charAt(i);
				if(s.isEmpty()) {
					s.push(c);
				} else {
					if(s.peek() == c) {
						s.pop();
					} else {
						s.push(c);
					}
				}
			}
			char[] result = new char[s.size()];
			for(int i = result.length -1; i >= 0; i--) {
				result[i] = s.pop();
			}
			
			System.out.println("#" + test_case + " " + new String(result));
		}
	}
}
