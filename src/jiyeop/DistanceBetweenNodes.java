package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DistanceBetweenNodes {
	/**노드 사이의 거리
	 * 거리를 구하는 문제라 bfs로 풀었다.
	 * */
	static ArrayList<Node>[] arr;
	static boolean[] visited;
	static class Node{
		int n;
		int dist;
		public Node(int n, int dist) {
			this.n = n;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		int dist = 0;
		visited = new boolean[N+1];
		for (int i = 1; i < N+1; i++) {
			arr[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int	b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Node(b,d));
			arr[b].add(new Node(a,d));
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
 			int end = Integer.parseInt(st.nextToken());
 			dist = calc(from,end);
 			Arrays.fill(visited, false);
 			System.out.println(dist);
		}
	}
	static int calc(int from, int end) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(from,0));
		visited[from] = true;
		int dist = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if(node.n == end) {
				dist = node.dist;
				break;
			}
			for (Node n : arr[node.n]) {
				if(!visited[n.n]) {
					q.add(new Node(n.n, n.dist + node.dist));
					visited[n.n] = true;
				}
			}	
		}
		return dist;
	}
}
