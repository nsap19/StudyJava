package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ResearchInstitute {
	/** 연구소 
	 * 벽을 세워서 바이러스를 막아라!
	 * 벽은 3개만 만들수있다. 0은 안전지대 1은 벽 2는 바이러스이다.
	 * 벽을 어떻게 세울까...
	 * 백트래킹으로 벽을 세워보자
	 * 1. 벽을 세운다
	 * 2. 바이러스를 퍼뜨린다
	 * 3. 안전구역을 센다 */
	static int N;
	static int M;
	static int[][] arr;
	static int[][] copyarr;//복제품
	static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max;
    static LinkedList<Pos> list = new LinkedList<Pos>();
    //포문으로 2를 찾아서 돌리지 않으려는 최소한의 장치
    static class Pos{
    	//포문으로 2를 찾아서 돌리지 않으려는 최소한의 장치
    	int x;
    	int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}    	
    }
    
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		copyarr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			
				if(arr[i][j] == 2) {
					list.add(new Pos(i, j));
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		MakeWall(0);
		
		System.out.println(max);
	}//main
	static void MakeWall(int depth) {
		if(depth == 3) {
			//벽을 다 세우고 바이러스 퍼뜨려보기
			for (int i = 0; i < N; i++) {
				copyarr[i] = arr[i].clone();
			}
			for (Pos p : list) {
				SpreadVirus(p.x, p.y);
			}
			
			max = Math.max(max, CheckSafe());
			
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					MakeWall(depth + 1);
					arr[i][j] = 0;
					//백트래킹으로 벽을 세워보자
					//여기서 시간초과 뜰줄알았는데 안뜸
				}
			}
		}
	}
	static void SpreadVirus(int x, int y) {	
		//바이러스를 퍼뜨리자
		//dfs로 퍼뜨리기
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				if(copyarr[nx][ny] == 0) {
					copyarr[nx][ny] = 2;
					SpreadVirus(nx, ny);
				}
			}
		}
	}
	static int CheckSafe() {
		//안전지역 체크
		int safe = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copyarr[i][j] == 0) {
					safe++;
				}
			}
		}
		return safe;
	}
}//연구소
