package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TheNumberOfIslands {
	/**
	 * 오류가 있었는데 w h 값을 잘못넣어서 생김
	 * */
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0 , 1, -1, -1, 1, -1, 1};
	static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			visited = new boolean[h][w];
			
			if(w == 0 && h == 0) {
				break;
			}
			
			for (int i = 0; i < h; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						//dfs(i,j);
						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < h && ny < w){
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}
	static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x,y));
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < h && ny < w){
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						q.add(new Node(nx, ny));
						visited[nx][ny] = true;
						//넣지 않으면 메모리 초과가 난다.
					}
				}
			}
		}
	}
}
