package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class UrbanDivisionPlan {
	/**
	 * 도시 분할 계획
	 * 길의 유지비 합을 최소로 하고싶다*/
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int dist;
		public Node(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			
			return dist -o.dist;
		}
	}
	static int N;
	static int M;
	static int[] parent;
	static int cnt;
	static int min;
	static int cost;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(from, to, dist));
		}
		
		for (int i = 1; i < N+1; i++) {
			parent[i]=i;
		}
		int min = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(union(node.from, node.to)) {
				min += node.dist;
				cost++;
			}
			if(cost == N-2) {
				break;
			}
		}
		System.out.println(min);
		

	}
	static int find(int a) {
		if(a==parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		return true;
	}
}
