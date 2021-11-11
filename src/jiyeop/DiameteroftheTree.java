package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DiameteroftheTree {
	static int N;
	static boolean[] visited;
	static ArrayList<Node>[] tree;
	static int max;
	static int max_node;
	static class Node{
		int edge;
		int dist;
		public Node(int edge, int dist) {
			this.edge = edge;
			this.dist = dist;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < N+1; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			tree[from].add(new Node(to,dist));
			tree[to].add(new Node(from,dist));
		}
		Arrays.fill(visited, false);	
		DFS(1, 0);
		
		Arrays.fill(visited, false);
		DFS(max_node, 0);
		
		System.out.println(max);
	}
	static void DFS(int v, int val) {
		if(val>max) {
			max = val;
			max_node = v;
		}
		visited[v] = true;
		for (int i = 0; i < tree[v].size(); i++) {
			if(!visited[tree[v].get(i).edge]) {
				DFS(tree[v].get(i).edge, val+tree[v].get(i).dist);
				visited[tree[v].get(i).edge] = true;
			}
		}
	}
}
