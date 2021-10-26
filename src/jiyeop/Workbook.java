package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Workbook {
	/**
	 * 문제집 조건
	 * 1. n개의 문제는 모두 풀어야한다.
	 * 2. 먼저 푸는 것이 좋은 문제가 있는 문제는 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야한다.
	 * 3. 가능하면 쉬운 문제를 먼저 풀어야한다. 
	 * 쉬운 문제란 번호수가 낮은 문제
	 * 기존 큐에서 우선순위큐로 바꾸니 쉽게 풀렸다.*/
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		int[] indegree = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			arr[from].add(to);
			indegree[to]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < N+1; i++) {
			if(indegree[i] == 0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int num = pq.poll();
			sb.append(num).append(" ");
			for (Integer i : arr[num]) {
				indegree[i]--;
				if(indegree[i] == 0) {
					pq.offer(i);
				}
			}
			
		}
		System.out.println(sb);
	}
}
