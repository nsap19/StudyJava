package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class MeetingPlace {
	static int[] parent;
	static int[] depth;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		depth = new int[N+1];
		arr = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 2; i < N+1; i++) {
			parent[i] = Integer.parseInt(br.readLine());
			arr[parent[i]].add(i);
		}
		bfs(1);
		for (int i = 0; i < M; i++) {
			st =new StringTokenizer(br.readLine());
			int pos1 = Integer.parseInt(st.nextToken());
			int pos2 = Integer.parseInt(st.nextToken());
			int num = LCA(pos1,pos2);
			sb.append(num).append("\n");
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
	static void bfs(int root) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 0; i < arr[now].size(); i++) {
				int node = arr[now].get(i);
				depth[node] = depth[now] + 1;
				queue.add(node);
			}
			
		}
	}
}