package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ShortCut {
	/**
	 * 지름길은 일방통행이고 역주행 할 수 없다.
	 * 못풀었다
	 * */
	static int N;
	static int D;
	static ArrayList<Node> arr = new ArrayList<Node>();
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int weight;
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.from, o.from);
			//시작정점을 기준으로 정렬해야함
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to  = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(to > D || to - from <= weight) continue;
			arr.add(new Node(from, to, weight));
		}
		Collections.sort(arr);
		
		int[] dp = new int[D+1];
		int temp = 0;
		int idx = 0;
		
		while(temp<D) {
			while(idx<arr.size()) {
				Node n = arr.get(idx);
				
				if(n.from != temp) break;
				if(dp[n.to] == 0) {
					dp[n.to] = dp[temp]+n.weight;
				}
				else {
					dp[n.to] = Math.min(dp[temp]+n.weight, dp[n.to]);
				}
				idx++;
			}
			if(dp[temp + 1] == 0) {
				dp[temp + 1] = dp[temp] + 1;
			}
			else {
				dp[temp + 1] = Math.min(dp[temp] + 1, dp[temp + 1]);
			}
			temp++;
		}
		System.out.println(dp[D]);
	}
}
