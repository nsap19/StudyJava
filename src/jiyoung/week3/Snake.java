package jiyoung.week3;

import java.util.LinkedList;
import java.util.Scanner;

public class Snake {
//	먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
//	만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
//	만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.

	public static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상우하좌
	public static int[][] map;
	public static int n;
	public static int time;
	public static boolean isFinish = false;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];

		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {	//사과
			map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
		}

		int l = sc.nextInt();
		ASnake.snake.add(new Integer[] { 0, 0 });	//뱀 시작
		map[0][0] = -1;
		int prev = 0;
		for (int i = 0; i < l; i++) {
			int t = sc.nextInt();
			String d = sc.next();

			switch (d) {
			case "D":	//1이면 우, -1이면 좌. 시간차이만큼 이동
				moving(t - prev, 1);	
				break;
			case "L":
				moving(t - prev, -1);
				break;
			}
			prev = t;
			if (isFinish)
				break;
		}
		if (!isFinish) {	//아직 안끝났으면 계속 움직임
			moving(Integer.MAX_VALUE, 0);
		}

		System.out.println(time);
	}

	public static void moving(int t, int d) {
		// 벽에 부딪히면 끝
		// t만큼 움직이며 사과를 먹나 확인
		// 다 움직였으면 방향갱신

		Integer[] head = ASnake.snake.getLast();
		int x = head[0];
		int y = head[1];
		int nd = ASnake.nowDir;

		for (int i = 0; i < t; i++) { // 움직임
			time++;
//			for (int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
//			System.out.println("============");
			x = x + dir[nd][0];
			y = y + dir[nd][1];
			if (isOut(x, y)) {
				isFinish = true;
				return;
			}

			ASnake.snake.add(new Integer[] { x, y });
			if (map[x][y] == 1) { // 사과있을때
				ASnake.length++;
				map[x][y] = -1; // 사과먹음
			} else {
				Integer[] tail = ASnake.snake.removeFirst();
				map[tail[0]][tail[1]] = 0; // 꼬리줄어듬
				map[x][y] = -1; // 뱀머리
			}
		}
		
		nd += d;	//방향갱신
		if (nd >= 4)
			nd = 0;
		if (nd < 0)
			nd = 3;
		ASnake.nowDir = nd;
	}

	public static boolean isOut(int x, int y) {	//벽/몸에박음
		if (x < 0 || x >= n || y < 0 || y >= n)
			return true;
		if (map[x][y] == -1)
			return true;
		return false;
	}

}

class ASnake {
	public static LinkedList<Integer[]> snake = new LinkedList<>();
	public static int length;
	public static int nowDir = 1;
}
