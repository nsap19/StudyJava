package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class YouToBeYuo {
	/**
	 * 가중치가 1이라 생각하고 다익스트라로 풀어봄*/
	static int N;
	static int M;
	static ArrayList<Node>[] arr;
	
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
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			arr[from].add(new Node(to,1));
			arr[to].add(new Node(from,1));
		}
		int Min = 0;
		Min = find_Min(a, b);
		System.out.println(Min);
	}
	
	static int find_Min(int start, int end) {
		int[] dist  = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(current.weight>dist[current.to]) {
				continue;
			}
			for (Node node : arr[current.to]) {
				int nextEnd = node.to;
				int newWeight = dist[current.to] + node.weight;
				
				if(newWeight < dist[nextEnd]) {
					dist[nextEnd] = newWeight;
					pq.add(new Node(nextEnd,newWeight));
				}
			}
		}
		if(dist[end] == Integer.MAX_VALUE) {
			return -1;
		}//처리 안해주면 틀림
		return dist[end];
	}
}
