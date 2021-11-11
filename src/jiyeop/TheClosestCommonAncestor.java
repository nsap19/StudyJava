package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TheClosestCommonAncestor {
	static int N;
	static int[] depth;
	static int[] parent;
	static ArrayList<Integer>[] arr;
	static boolean[] findroot;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			N = Integer.parseInt(br.readLine());
			arr = new ArrayList[N+1];
			findroot = new boolean[N+1];
			parent = new int[N+1];
			depth = new int[N+1];
			Arrays.fill(findroot, false);
			for (int i = 0; i < N+1; i++) {
				arr[i] = new ArrayList<>();
			}
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				arr[p].add(s);
				findroot[s] = true;
			}
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int root = 0;
			for (int i = 1; i < N+1; i++) {
				if(!findroot[i]) {
					root = i;
					break;
				}
			}
			//System.out.println(root);
			bfs(root);
			int answer = LCA(t1, t2);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
	static int LCA(int t1,int t2) {
		while(true) {
			if(t1==t2) {
				return t1;
			}
			if(depth[t1]==depth[t2]) {
				while(t1!=t2) {
					t1 = parent[t1];
					t2 = parent[t2];
				}
			}
			else if(depth[t1]>depth[t2]) {
				while(depth[t1]>depth[t2]) {
					t1= parent[t1];
				}
			}
			else {
				while(depth[t1]<depth[t2]) {
					t2 = parent[t2];
				}
			}
		}
	}
	static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 0; i < arr[now].size(); i++) {
				int child = arr[now].get(i);
				if(parent[child]!=0) {
					continue;
				}
				parent[child] = now;
				depth[child]  = depth[now]+1;
				queue.add(child);
			}
		}
	}
}
