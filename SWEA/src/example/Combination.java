package example;

public class Combination {
	static int[] t = new int[3];
	static int[] a = { 1, 2, 3 };
	static int N = 3, R = 2;

	public static void main(String[] args) {
		comb(N, R);
	}

	static void comb(int n, int r) {
		if (r == 0)
			printArr();
		else if (n < r)
			return;
		else {
			t[r-1] = a[n-1];
			comb(n-1, r-1);
			comb(n-1, r);
		}
	}

	static void printArr() {
		for(int i = 0; i< R; i++) {
			System.out.print(t[i] + " ");
		} System.out.println();
	}
}
