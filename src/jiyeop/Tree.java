package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree {
	/**
	 * 
	 * 전위  3/ 6/ 5 4/ 8/ 7 /1 /2 
	 * 중위  5 /6 /8 4 /3 /1/ 2/ 7
	 * 후위  5 /8 4/ 6/ 2 /1 /7 /3
	 * R = 2 5 4 1 7 6 5 0 
	 * 전위순회 값으로 중위순회를 이분할한다.
	 * */
	static int[] pre;
	static int[] in;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			pre = new int[N+1];
			in = new int[N+1];
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}
			postorder(0, N, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void postorder(int start, int end, int r) {
		for (int i = start; i < end; i++) {
			if(pre[r] == in[i]) {
				postorder(start, i, r + 1);
				postorder(i+1, end, r+i-start+1);
				//전위순회 값으로 중위 순회 값을 이분할한다.
				sb.append(pre[r]).append(" ");
			}
		}
	}
}
