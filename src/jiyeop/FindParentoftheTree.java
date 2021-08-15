package jiyeop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FindParentoftheTree {
	/**리스트로 구현하기
	 * 연결리스트를 배열로 선언
	 * 
	 * */
	//결과 저장배열
	static int[] result; 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer>[] arr;
		//입력
		int N = Integer.parseInt(br.readLine());
		
		//입력
		result = new int[N+1];
		
		//초기화는 한번에 안되는 것 같다
		arr = new LinkedList[N+1];
		
		//방문했니?
		boolean[] visited = new boolean[N+1];
		
		//연결리스트 배열마다 연결리스트 선언?
		for (int i = 0; i <= N; i++) {
			arr[i] = new LinkedList<Integer>();
		}
		/**
		 * 입력 받기 
		 * 저장하기
		 * */
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			arr[num1].add(num2);
			arr[num2].add(num1);
		}
		//깊이 우선 탐색
		dfs(1,arr, visited);
		
		//출력
		for (int i = 2; i <=N; i++) {
			System.out.println(result[i]);
		}
		
	}
	public static void dfs(int v,LinkedList<Integer>[] 
								List, boolean[] visited) {
		if(visited[v]) {
			return;
			//true면 나가기
		}
		visited[v] = true;//방문시 true
		for (int k : List[v]) {
			//list 돌리기
			if(!visited[k]) {
				result[k]=v;
				//v->k로 연결 
				dfs(k,List,visited);
			}
		}
	}
}
