package stack2;

import java.util.*;
import java.io.*;

public class ID_1224 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[] cal = br.readLine().toCharArray();

			System.out.print("#" + test_case + " ");
			System.out.println(calculate(cal, N));
		}
	}

	private static int calculate(char[] cal, int N) {
		Stack<Integer> s = new Stack<Integer>();
		ArrayList<Character> postfix = toPostfix(cal, N);
		
		for (int i = 0; i < postfix.size(); i++) {
			char c = postfix.get(i);
			if(c == '+') {
				s.push(s.pop() + s.pop());
			} else if (c == '*') {
				s.push(s.pop() * s.pop());
			} else {
				s.push(c - '0');
			}
		}

		return s.pop();
	}

	private static ArrayList<Character> toPostfix(char cal[], int N) {
		Stack<Character> s = new Stack<Character>();
		ArrayList<Character> postfix = new ArrayList<Character>();

		for (int i = 0; i < N; i++) {
			if (cal[i] == '+') {
				while(!s.isEmpty() && s.peek() != '(') {
					postfix.add(s.pop());
				}
				s.push(cal[i]);
			} else if (cal[i] == '*') {
				while(!s.isEmpty() && s.peek() == '*') {
					postfix.add(s.pop());
				}
				s.push(cal[i]);
			} else if (cal[i] == '(') { // 여는 괄호는 무조건 스택에 push
				s.push(cal[i]);
			} else if (cal[i] == ')') { // 여는 괄호 나올때 까지 pop
				while (!(s.peek() == '(')) {
					postfix.add(s.pop());
				}
				s.pop();
			} else {
				postfix.add(cal[i]); // 피연산자는 list에 add
			}
		}
		while(!s.isEmpty()) {
			postfix.add(s.pop());
		}

		return postfix;
	}
}
