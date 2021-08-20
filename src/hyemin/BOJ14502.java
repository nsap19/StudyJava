package hyemin;

//백준 14502 연구소
//입력
//첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)
//둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.
//빈 칸의 개수는 3개 이상이다.
//
//출력
//첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus {
    int r, c;

    public Virus(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class BOJ14502 {
    static int N, M, max = Integer.MIN_VALUE;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);

        System.out.println(max);
    }

    //벽 세우기
    private static void makeWall(int cnt) {
        if (cnt == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    makeWall(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus() {
        //배열 복사
        int[][] copyArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(arr[i], 0, copyArr[i], 0, M);
        }

        //바이러스 찾아서 큐에 넣기
        Queue<Virus> virus = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyArr[i][j] == 2) {
                    virus.add(new Virus(i, j));
                }
            }
        }

        //바이러스 퍼트리기
        while (!virus.isEmpty()) {
            Virus cur = virus.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (copyArr[nr][nc] == 0) {
                        virus.add(new Virus(nr, nc));
                        copyArr[nr][nc] = 2;
                    }
                }
            }
        }

        getSafeArea(copyArr);
    }

    //안전 영역 구하기
    private static void getSafeArea(int[][] copyArr) {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyArr[i][j] == 0) safeArea++;
            }
        }

        max = Math.max(safeArea, max);
    }
}
