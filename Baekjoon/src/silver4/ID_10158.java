package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ID_10158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		int x = (q+t)%(2*w);
		int y = (p+t)%(2*h);
		
		x = w - Math.abs(w - x);
		y = h - Math.abs(h - y);
		
		bw.write(String.format("%d %d\n", x, y));
		bw.flush();
	}
}
