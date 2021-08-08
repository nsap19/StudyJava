package jiyeop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Snake {
	/**
	 * 게임은 n*n 정사각형 보드위/ 임의로 1~N까지
	 * 뱀은 1,1 에 위치/ 뱀의 길이 1/뱀은 오른쪽으로 움직인다
	 * 매 초마다 이동/ 사과를 먹으면 길이가 길어짐/ 사과를 먹지않으면 길이가 안길어짐
	 * 뱀은 벽이나 자기자신에 부딪히면 죽는다
	 * x초간 이동 L은 왼쪽으로 턴 D는 오른쪽으로 턴 */
	static int[][] map = new int[101][101];//map
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0}; //변환해 보자
	static int time = 0;
	static int N;//맵의 크기
	static int K;//사과수 입력
	static int L;//방향 변환 횟수 L
	static Deque<Pos> dq = new LinkedList<Pos>();//길이 저장/머리 꼬리를 더해야되니 덱으로선언
	static Queue<Integer> timeq = new LinkedList<Integer>();//시간큐
	static Queue<String> turnq = new LinkedList<String>();//터닝 명령 큐
	//좌표를 저장할 클래스
	static class Pos{
		int x;
		int y;
		
		public Pos() {
		}
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		dq.add(new Pos(1,1));
		map[1][1]=2;
		//사과 위치 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;//사과는 1에 있어
		}
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int move = Integer.parseInt(st.nextToken());
			String turn = st.nextToken();
			timeq.add(move);
			turnq.add(turn);
		}
		playgame(0, 1, 1);
		System.out.println(time);

		
	}
	public static void playgame(int num, int startx, int starty) {
		/** 
		 * 시작인덱스(start), 방향전환 인덱스(num)를 받아옴
		 * while문으로 계속돌리자
		 * 문제를 잘읽자
		 * 나는 4 d/ 5 d 면 4초후 턴하고 5초후 턴하는줄알았다.
		 * 근데 그냥  4초후 턴하면 1초후 턴하는 것이었다.
		 * 인덱스 0 1 1 
		 * */
		while(true) {		
			//큐가 안비어있고 시간은 큐에서 나오는 시간과 같을떄
			if(!timeq.isEmpty() && time == timeq.peek()) {
				timeq.poll();//시간 뺴기
				//d면 오른쪽 l이면 왼쪽 3 
				if(turnq.peek().equals("D")) {
					num = (num + 1) % 4;
				}
				else {
					num = (num + 3) % 4;
				}
				turnq.poll();//턴명령어 빼기
			}
			
			int nx = startx + dx[num];//다음 좌표
			int ny = starty + dy[num];//다음 좌표
			dq.addFirst(new Pos(nx,ny));//dq에 저장!
			
			//벽에 박으면 죽어
			if(nx<=0 || ny<=0 || nx>=N+1 || ny>=N+1) {
				time++;
				break;
			}
			
			if(map[nx][ny]==1) {
				//사과가 있으면 길이가 늘어남 
				//위에서 덱에 저장했으니 맵에서만 바꿔줌
				map[nx][ny]=2;
			}
			else if(map[nx][ny]==0) {
				//사과가 없으면 길이는 그대로
				//맵에서 2로 저장 덱에 저장된 마지막인덱스 맵 -> 0
				//마지막 인덱스 뺴기
				map[nx][ny] = 2;
				map[dq.peekLast().x][dq.peekLast().y] = 0;
				dq.pollLast();
			}
			else {
				//그외 자기몸에 박았을때
				time++;
				break;
			}
			//시작인덱스 저장
			startx = nx;
			starty = ny;
			time++;
			//시간증가
		}
	}
}
