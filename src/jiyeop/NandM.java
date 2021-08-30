package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NandM {
	/**
	 * N과M
	 * swap으로 하니까 사전순대로 안된다. 
	 * 다른방법으로 순열 구현함*/
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		output = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(arr, output, visited, 0, N, M);
		
	}
	static void perm(int[] arr, int[] output,boolean[] visited, int depth, int n, int r) {
		if(depth == r) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < r; i++) {
				sb.append(output[i]).append(" ");
			}
			System.out.println(sb);
			
			return;
		}
		for (int i = 0; i < n; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}
}
