package jiyeop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExpressionOfGathering {
	/**
	 * 집합의 표현*/
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			
			if(num == 0) {
				union(a, b);
			}
			else {
				if(find(a) != find(b)) {
					sb.append("NO").append("\n");
				}
				else {
					sb.append("YES").append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	//부모찾기
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	//합치기
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
