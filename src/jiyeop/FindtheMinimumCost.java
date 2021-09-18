package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class FindtheMinimumCost {
	/**
	 * 최소비용 구하기
	 * arraylist와 우선순위큐를 이용해 구하는게
	 * 메모리가 작고 시간이 빠름 다익스트라 풀면서 visit배열이 필요할때도 있고
	 * 안필요할때도 있는듯
	 * */
	static int N;//도시의 개수
	static int M;//버스의 개수
	static int start;//시작
	static int end;//도착
	
	static ArrayList<Node>[] map;
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight,o.weight);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new ArrayList[N+1];
		
		for (int i = 0; i < map.length; i++) {
			map[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map[from].add(new Node(to,weight));
		}
		st = new StringTokenizer(br.readLine()," ");
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int MinimumCost = 0;
		MinimumCost = find_Mindist(start, end);
		System.out.println(MinimumCost);
		
	}
	static int find_Mindist(int start, int end) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0 ;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			
			if(current.weight>dist[current.to]) {
				continue;
			}
			for (Node node : map[current.to]) {
				int nextEnd = node.to;
				int newWeight = dist[current.to]+node.weight;
				
				if(newWeight < dist[nextEnd]) {
					dist[nextEnd] = newWeight;
					pq.add(new Node(nextEnd,newWeight));
				}
			}
		}
		return dist[end];
	}
}
