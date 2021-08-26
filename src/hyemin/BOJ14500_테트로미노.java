package hyemin;
/**
 * 테트로미노
 *
 * 정사각형은 서로 겹치면 안 된다.
 * 도형은 모두 연결되어 있어야 한다.
 * 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
 *
 * 아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
 * 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
 * 테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.
 */

import java.io.*;
import java.util.*;

public class BOJ14500_테트로미노 {
    static int N, M, max = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                tetro1(i, j, 1, arr[i][j]);
                tetro2(i, j, 1, arr[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);

    }

    private static void tetro1(int r, int c, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];


            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                tetro1(nr, nc, cnt + 1, sum + arr[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }

    private static void tetro2(int r, int c, int cnt, int sum) { // ㅓ,ㅗ,ㅏ,ㅜ 모양의 테트로미노 처리
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];


            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                if (cnt == 2) { //ㅓ,ㅗ,ㅏ,ㅜ 의 중심 부분일 때 다음값으로 이동하지 않고, 현재 위치에서 다음 위치를 찾아야함
                    tetro2(r, c, cnt + 1, sum + arr[nr][nc]);
                } else tetro2(nr, nc, cnt + 1, sum + arr[nr][nc]);
                visited[nr][nc] = false;
            }
        }

    }
}
