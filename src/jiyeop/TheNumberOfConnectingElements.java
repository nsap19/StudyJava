package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TheNumberOfConnectingElements {
	/**
	 * 연결요소의 개수
	 * 연결요소란? 그래프 개수를 말하는듯?
	 * */
	static int N;
	static int M;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cnt = 0;//연결요소 세기
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				//순회할 때마다 센다
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		for (int k : arr[start]) {
			if(!visited[k])
				dfs(k);
		}
	}
}
