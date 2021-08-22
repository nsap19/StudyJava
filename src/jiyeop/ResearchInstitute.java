package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ResearchInstitute {
	/** 연구소 
	 * 벽을 세워서 바이러스를 막아라!
	 * 벽은 3개만 만들수있다. 0은 안전지대 1은 벽 2는 바이러스이다.
	 * 벽을 어떻게 세울까...*/
	static int N;
	static int M;
	static int[][] arr;
	static int[][] copyarr;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max;
    static LinkedList<Pos> list = new LinkedList<Pos>();
    
    static class Pos{
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
		visited = new boolean[N][M];
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
				}
			}
		}
	}
	static void SpreadVirus(int x, int y) {	
		
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
