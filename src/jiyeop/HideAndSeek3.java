package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek3 {
	/**수빈 동생 숨바꼭질
	 * 수빈이는 걷거나 순간이동 가능
	 * 만약 X위치일때 1초 후 X-1 OR X+1로 이동하게된다. 
	 * 순간이동하면 2*X의 위치로 이동하게 된다.
	 * 위치와 시간 ? 저장
	 * 왜 bfs인지 잘모르겠다. 그냥 점을 저장한다라고 생각하고 풀었는데
	 * bfs와 다익스트라로 분류되있지 모르겠다.*/
	static int N;
	static int K;
	static boolean[] visited = new boolean[100001];
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		BFS();
		System.out.println(answer);
	}
	
	static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(N,0));
		while(!q.isEmpty()) {
			Node node = q.poll();
			visited[node.x] = true;
			if(node.x == K) {
				answer = Math.min(answer, node.time);
			}
			
			if(node.x + 1 <= 100000 && !visited[node.x + 1]) {
				q.add(new Node(node.x + 1, node.time + 1));
			}
			if(node.x * 2 <= 100000 && !visited[node.x * 2]) {
				q.add(new Node(node.x * 2, node.time));
			}
			if(node.x - 1 >= 0 && !visited[node.x - 1]) {
				q.add(new Node(node.x - 1, node.time + 1));
			}
			
		}
		
	}
	static class Node{
		int x;
		int time;
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
}
