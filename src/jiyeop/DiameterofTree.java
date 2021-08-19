package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DiameterofTree {
	/**
	 * DFS 한번만 돌려서 될줄 알았는데 - 오류
	 * 다익스트라는 안해봄
	 * 4%에서 틀리는 케이스 시작정점에 따라 값이 달라지는 경우
	 * 계속 시작정점을 바꿔 돌린다면 시간초과가 남 - 케이스 대입시 답은 정확함
	 * 참고를 해도 잘 모르겠음 
	 * 임의 노드에서 시작 먼노드를 찾음 그 노드에서 dfs시작
	 * 결국이것도 시작노드를 바꿔서 dfs를 돌린다 생각이 드는데 중간 프로세스에서
	 * 시간단축이 꽤 되는것 같다.
	 * 
	 * 참고 후에도 시간 초과가 떳는데 선언 문제였다.
	 * linkedlist -> arraylist로 바꿔주었다.
	 * arraylist에서 인덱스 값을 찾는 방식과 linkedlist가 인덱스 찾는 방식이 다름
	 * linkedlist의 경우 i번째 접근시 head부터 i까지 순회 접근
	 * arraylist에 경우 배열처럼 인덱스로 접근하는 방식인듯
	 * 아마 접근에서 오래걸려서 시간초과가 난듯함
	 * */
	static int V;
	static int max;
	static int node;
	static boolean[] visited;
	static ArrayList<Node>[] tree;
	static class Node{ // 저장노드
		int edge;
		int dis;
		public Node() {
		}
		public Node(int edge, int dis) {
			this.edge = edge;
			this.dis = dis;
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V+1];
		visited = new boolean[V+1];
		for(int i = 1; i < V + 1; i++) {
            tree[i] = new ArrayList<Node>();
        }
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			while(true)
			{
				int edge = Integer.parseInt(st.nextToken());
				if(edge==-1) {
					break;
					//-1입력시 탈출
				}
				int dis = Integer.parseInt(st.nextToken());
				tree[n].add(new Node(edge, dis));	
			}
		}
//		for (int i = 1; i < V + 1; i++) {
//			Arrays.fill(visited, false);
//			DFS(i,0);
//		}
		Arrays.fill(visited, false);
		DFS(1,0);
		
		Arrays.fill(visited, false);
		DFS(node,0);
		
		System.out.println(max);
	}
	static void DFS(int v, int val) {
		if(val > max) {
			max = val;
			node = v;
			//계속 max를 최신화 하기 때문에 return은 없다.
		}
		visited[v] = true;
		for (int i = 0; i < tree[v].size(); i++) {
			if(!visited[tree[v].get(i).edge]) {
				DFS(tree[v].get(i).edge,val+tree[v].get(i).dis);
				visited[tree[v].get(i).edge] = true;
			}
		}
	}
}
