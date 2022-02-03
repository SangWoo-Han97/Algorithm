package stack1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ID_1218 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String temp = br.readLine();

			boolean isPossible = true;
			Stack<Character> stack = new Stack<Character>();
			
			for(int i = 0; i < N; i++) {
				char c = temp.charAt(i);
				switch (c) {
				case ']':
					if (stack.peek() == '[') stack.pop();
					else isPossible = false;
					break;
				case ')':
					if (stack.peek() == '(') stack.pop();
					else isPossible = false;
					break;
				case '>':
					if (stack.peek() == '<') stack.pop();
					else isPossible = false;
					break;
				case '}':
					if (stack.peek() == '{') stack.pop();
					else isPossible = false;
					break;
				default: stack.push(c); break;
				}					
			}
			System.out.print("#" + test_case + " ");
			System.out.println(isPossible ? 1 : 0);
		}
	}
}
