package example;


public class Perm {
	static int[] arr = { 1,2,3,4,5,6,7,8,9,10 };

	public static void main(String[] args) {
		perm(0,  10,  10);
	}
	
	private static void perm(int depth, int n, int r) {
		if(depth == r) {
			for(int i = 0; i<r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			for(int i = depth; i<n; i++) {
				swap(depth, i);
				perm(depth+1, n, r);
				swap(depth, i);				
			}
		}
	}
	
	private static void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
