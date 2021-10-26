package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LineUp {
	/**
	 *  줄세우기
	 *  위상정렬
	 *  키순서 대로 세우기
	 *  답이 여러 가지인 경우에는 아무거나 출력한다
	 *  */
	static ArrayList<Integer>[] arr;
	static int[] indegree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		indegree= new int[N+1];
		arr = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
			indegree[to]++;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 1; i < N+1; i++) {
			if(indegree[i]==0) {
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node).append(" ");
			for (Integer i : arr[node]) {
				indegree[i]--;
				if(indegree[i] == 0) {
					queue.offer(i);
				}
			}
		}
		System.out.println(sb);
	}
}
