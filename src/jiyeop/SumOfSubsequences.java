package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSubsequences {
	static int[] arr;
	static boolean[] visited;
	static int cnt;
	static int N;
	static int S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		comb(0);
		if(S==0) {
			System.out.println(cnt-1);
		}
		else {
			System.out.println(cnt);
		}
	}
	
	static void comb(int r) {
		if(N == r) {
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(visited[i]==true) {
					sum+=arr[i];
				}
			}
			
			if(sum == S) {
				cnt++;
			}
			return;
		}
		visited[r] = true;
		comb(r+1);
		visited[r] = false;
		comb(r+1);
	}
}
