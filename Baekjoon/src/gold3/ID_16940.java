package gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ID_16940 {
	static ArrayList<ArrayList<Integer>> adj;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<Integer>());
		}

		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adj.get(from).add(to);
			adj.get(to).add(from);
		}

		int[] answer = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}		
		
		checkBfs(answer);
	}

	private static void checkBfs(int[] answer) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];

		q.offer(1);
		visited[1] = true;
		
		int index = 1;
		
		HashSet<Integer> set = new HashSet<>();
		while (!q.isEmpty()) {
			set.clear();
			
			int t = q.poll();
			
			for(int next: adj.get(t)) {
				if(visited[next]) continue;
				
				set.add(next);
				visited[next] = true;
			}
			
			int size = set.size();
			
			for (int i = index; i < index+size; i++) {
				if(set.contains(answer[i])) {
					q.offer(answer[i]);
				} else {
					System.out.println(0);
					return;
				}
			}
			
			index += size;
		}
		
		System.out.println(1);
	}
}
