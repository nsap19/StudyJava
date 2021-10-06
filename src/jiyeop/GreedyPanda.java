package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class GreedyPanda {
	static int N;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int[][] map;
	static int[][] dp;
	
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, dfs(i,j));
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}

		System.out.println(max);
	}
	static int dfs(int x, int y) {
//		dp 배열에 시작점을 기준으로 움직이는 횟수를 계산
		if(dp[x][y]!=0) {
			return dp[x][y];
		}
		//dp배열을 모두 0으로 정의하고 점마다 순회했는데 시간초과가 뜸
		//애초에 dp배열에 값이 정해지?므로 갱신된 경우 순회를 안해주는 코드를
		//넣어야 시간이 줄어듬
		dp[x][y]=1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(map[x][y] < map[nx][ny]) {
					dp[x][y] = Math.max(dp[x][y], dfs(nx,ny) + 1);
					//발상은 쉬운데 코드구성이 어려운것 같다
				}
			}
		}
		return dp[x][y];
	}
}
