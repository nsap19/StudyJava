package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tetromino {
	/**
	 * 폴리오미노 1*1 정사각형 여러개를 붙인것
	 * 정사각형 4개를 이어붙인 것이 테트로미노
	 * 문제를 잘읽자 -> 문제를 안읽는 경향이 있는 듯
	 * 테트로미노가 놓인 칸에 쓰인 수들에 합을 구하자.
	 * 테트로미노가 놓여서 행렬을 가득채우는게 아니다.
	 * dfs로는 ㅜ모양을 찾을수가없다. */
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			Arrays.fill(visited[i], false);
			for (int j = 0; j < M; j++) {	
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				DFS(i, j, 0, 0);
				//DFS(i, j, 0, arr[i][j])로 보내면 i=2 j=3 때 20 이나오는데
				//처음 인덱스를 true로 안바꿔줬고 r=3까지로 계산했는데 틀렸다고 나온다.
				//그래서 처음인덱스는 빼고 다음인덱스부터 r=4까지 계산하기로했다. 처음인덱스를 넣게되면 5개의 정사각형을 계산
				//System.out.println("1 : " + max);
				checkshape(i, j);
				//System.out.println("2 : " + max);
			}
		}
		System.out.println(+ max);
	}
	static void DFS(int x,int y, int r, int sum) {
		/**ㄴㅁㅡ 만들기
		 * dfs로 길이가 4가되면 멈춰!
		 * */
		if(r == 4) {
			max = Math.max(max, sum);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nx = x + dr[k];
			int ny = y + dc[k];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					DFS(nx, ny, r + 1, sum + arr[nx][ny]);
					visited[nx][ny] = false;
				}
			}
		}
	}// dfs
	static void checkshape(int x, int y) {
		/**ㅗㅜㅏㅓ 모양만들기
		 * 어렵다..!
		 * ┼여기서 하나씩 제외하자
		 * */
		int side = 0;
		int min = 9999;
		int sum = arr[x][y];
		for (int k = 0; k < 4; k++) {
			int nx = x + dr[k];
			int ny = y + dc[k];
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				side++;
				sum += arr[nx][ny];
				min = Math.min(min, arr[nx][ny]);
			}			
		}
		if(side < 3) {
			return;
		}
		if(side == 4) {
			sum = sum - min;
		}
		max = Math.max(max, sum);
		
	}//ㅗ모양체크
}//테트로미노
