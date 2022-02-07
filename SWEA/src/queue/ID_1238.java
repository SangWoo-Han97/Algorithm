package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ID_1238 {
	static LinkedList<Set<Integer>> adj;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			
			adj = new LinkedList<>();		//인접리스트 초기화
			for(int i = 0; i<=100; i++) {
				adj.add(new HashSet<>());
			}
			visited = new int[101];
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());				
				adj.get(from).add(to);				
			}
			
			System.out.print("#" + test_case + " ");
			bfs(start);
		}
	}
	
	private static void bfs(int start) {
		Queue<Node> q = new LinkedList<Node>();
		LinkedList<Node> l = new LinkedList<Node>();	// 같은 레벨 표시를 위한 리스트
		
		q.add(new Node(start, 0));
		l.add(new Node(start, 0));
		visited[start] = 1;
		
		while(!q.isEmpty()) {
			Node t = q.poll();
			if(l.getLast().level != t.level) {
				l.clear();
			}
			l.add(t);
			
			Iterator<Integer> it = adj.get(t.num).iterator();
			while(it.hasNext()) {
				int u = it.next();
				if(visited[u] != 1) {
					q.add(new Node(u, t.level + 1));
					visited[u] = 1;
				}
			}
		}
		int max = -1;
		for(int i = 0; i< l.size(); i++) {
			if(max <= l.get(i).num) {
				max = l.get(i).num;
			}
		}
		System.out.println(max);
	}
}

class Node {	// 자기 번호, 큐 탐색 레벨
	int num, level;
	public Node(int num, int level) {
		this.num = num; this.level = level;
	}
}