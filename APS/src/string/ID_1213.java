package string;

import java.io.*;

public class ID_1213 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			String word = br.readLine();
			
			String str = br.readLine();
			
			int sum = 0, index = 0;			
			
			// 문자열 못찾을때 까지 반복
			while((index = str.indexOf(word, index)) > -1) {	
				sum++;
				index += word.length();
			}

			System.out.print("#" + test_case + " ");
			System.out.println(sum);
		}
	}
}
