package jiyoung.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tetromino {

//	G5 14500 테트로미노

//	크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
//	테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
//	테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

//	첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
//	둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
//	첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.

	// 각 자리에서 취할수 있는 모든 테트로미노를 해보고 최댓값찾음
	// 테트로미노는 걍 자리에서 네번 움직이면됨 -> ㅗ를 못봄
	//

	static int n, m;
	static int[][] paper;
	static boolean[][] isVisited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상하좌우
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		isVisited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				isVisited[i][j] = true;
				tetromino(1, i, j, paper[i][j]);
				isVisited[i][j] = false;
				getMountain(i,j);	//ㅗ모양만 따로해줬음..방법 못찾겠어서ㅜ
			}
		}
		
		System.out.println(max);
	}

	public static void tetromino(int cnt, int x, int y, int sum) {
		if (cnt == 4) {
			max = max > sum ? max : sum;
			return;
		}
		int nx = 0, ny = 0;
		for (int i = 0; i < dir.length; i++) {
			nx = x + dir[i][0];
			ny = y + dir[i][1];
			if (isOK(nx, ny)) { // 범위도 안나가고 방문도 안했음
				isVisited[nx][ny] = true;
				tetromino(cnt + 1, nx, ny, sum + paper[nx][ny]);
				isVisited[nx][ny] = false;
			}
		}
	}

	public static boolean isOK(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m || isVisited[x][y])
			return false;
		return true;
	}

	public static void printMap() {
		System.out.println("=================");
		for (int[] p : paper) {
			System.out.println(Arrays.toString(p));
		}
	}

	//ㅗ모양 처리하기
	//범위나간경우 -1로 해주고 정렬해서 상위값3개 + 현재위치 더함
	//범위 나간경우 최대일수가 없기때문에 -1더해도 ㄱㅊ
	public static void getMountain(int x, int y) {
		int[] num = new int[4];
		int nx, ny;
		for (int i = 0; i < dir.length; i++) {
			nx = x + dir[i][0];
			ny = y + dir[i][1];
			if (isOK(nx, ny)) {
				num[i] = paper[nx][ny];
			} else {
				num[i] = -1; // 범위나간거
			}
		}
		Arrays.sort(num);
		int sum = paper[x][y];
		for (int i = 1; i < num.length; i++) {
			sum += num[i];
		}
		max = max > sum ? max : sum;
	}
}
