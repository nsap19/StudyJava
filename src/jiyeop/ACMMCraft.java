package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMMCraft {
	/**ACM CRAFT
	 * 위상정렬 활용
	 * 그래프의 싸이클이없고 유향그래프여야함
	 * 간선이 연결된 갯수 순으로 출력*/
	static int W;
	static int N;
	static int K;
	static int[] D;
	static int[] indegree;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			D = new int[N+1];
			arr = new ArrayList[N+1];
			//그래프
			indegree = new int[N+1];
			//연결된 간선의 개수
			for (int i = 0; i < N+1; i++) {
				arr[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 1; i < N+1; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				arr[from].add(to);
				indegree[to]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			
			TopologicalSort();
		}
	}
	static void TopologicalSort() {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] result = new int[N+1];
		//거리 저장 배열
		for (int i = 1; i < N+1; i++) {
			result[i] = D[i];
			if(indegree[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			
			for (Integer i : arr[node]) {
				result[i] = Math.max(result[i], result[node]+D[i]);
				
				indegree[i]--;
				if(indegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		System.out.println(result[W]);
	}	
}
