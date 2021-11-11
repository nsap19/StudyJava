package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoTrip {
	static int[] parents;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		
		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				int K = Integer.parseInt(st.nextToken());
				if(K == 1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = find(Integer.parseInt(st.nextToken()));
		
		for (int i = 1; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			if(start != find(now)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

}
