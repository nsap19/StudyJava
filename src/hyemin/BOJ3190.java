package hyemin;

import java.io.*;
import java.util.*;

public class BOJ3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //보드의 크기 (N * N)
        int K = Integer.parseInt(br.readLine()); //사과의 갯수

        //사과의 위치 저장
        int[][] apples = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            apples[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine()); //방향변환정보 갯수
        HashMap<Integer, String> dir = new HashMap<>(); //초로 방향변환정보를 찾기위해 hashMap으로 저장
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            dir.put(Integer.parseInt(st.nextToken()), st.nextToken()); //key초후에 value방향으로 전환(L=왼쪽, D=오른쪽 90도 전환)
        }

        int time = 0;
        Deque<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{1, 1}); //뱀 머리 시작위치
        int[] dr = {0, 1, 0, -1}; //1씩 증가하면 D방향, 1씩 감소하면 L방향
        int[] dc = {1, 0, -1, 0};
        int di = 0, nr = 1, nc = 1; //di는 방향 인덱스. dr, dc의 인덱스
        loop:
        while (true) {
            time++;
            nr += dr[di];
            nc += dc[di];

            //범위 체크
            if (nr > N || nc > N || nr <= 0 || nc <= 0) break;
            //자신의 몹과 부딪히는지 확인
            for (int[] arr : snake) {
                if (arr[0] == nr && arr[1] == nc) break loop;
            }


            //사과를 먹지 않았을때
            if (apples[nr][nc] != 1) snake.pollLast();
            else { //사과를 먹었다면 사과는 없어짐
                apples[nr][nc] = 0;
            }

            //머리를 다음칸에 위치
            snake.offerFirst(new int[]{nr, nc});


            if (dir.get(time) != null) {
                if (dir.get(time).equals("D")) {
                    if (di == 3) di = 0;
                    else di++;
                } else {
                    if (di == 0) di = 3;
                    else di--;
                }
            }
        }
        System.out.println(time);

    }
}
