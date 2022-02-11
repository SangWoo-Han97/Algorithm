package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_2527 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Square first = new Square(st);
			Square second = new Square(st);
			if (compareD(first, second)) {
				bw.write("d");
			} else if (compareB(first, second)) {
				bw.write("b");
			} else if (compareC(first, second)) {
				bw.write("c");
			} else {
				bw.write("a");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean compareB(Square first, Square second) {
		// if ((first.q == second.y ) || (first.p == second.x) || (first.x == second.p)
		// || (first.y == second.q)) {
		if ((first.p == second.x && first.q != second.y) || (first.x == second.p && first.q != second.y)
				|| (first.p != second.x && first.y == second.q) || (first.x != second.p && first.y == second.q)) {
			return true;
		}
		return false;
	}

	public static boolean compareC(Square first, Square second) {
		if ((first.x == second.p && first.y == second.q) || (first.p == second.x && first.y == second.q)
				|| (first.p == second.x && first.q == second.y) || (first.x == second.p && first.q == second.y)) {
			return true;
		}
		return false;
	}

	public static boolean compareD(Square first, Square second) {
		if ((first.p < second.x) || (first.x > second.p) || (first.q < second.y) || (first.y > second.q)) {
			return true;
		}
		return false;
	}
}

class Square {
	int x, y, p, q;

	public Square(StringTokenizer st) {
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
	}
}