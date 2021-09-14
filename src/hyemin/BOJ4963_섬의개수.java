package hyemin;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.
 * 두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다.
 * 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

 * 입력은 여러 개의 테스트 케이스로 이루어져 있다.
 * 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.
 * 둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
 * 입력의 마지막 줄에는 0이 두 개 주어진다.
 *
 * 각 테스트 케이스에 대해서, 섬의 개수를 출력한다.*/

class Land {
    int x, y;

    public Land(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ4963_섬의개수 {
    static int w, h;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        while (!str.equals("0 0")) {
            st = new StringTokenizer(str, " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            //초기화
            int[][] map = new int[h + 2][w + 2];
            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            search(map);
            str = br.readLine();
        }

        System.out.println(sb);

    }

    private static void search(int[][] map) {
        int[] dr = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        int count = 0;
        Queue<Land> queue = new LinkedList<>();

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (map[i][j] == 1) {
                    count++;
                    queue.add(new Land(i, j));

                    while (!queue.isEmpty()) {
                        Land land = queue.poll();
                        int r = land.x;
                        int c = land.y;
                        int nr, nc;
                        for (int k = 0; k < 8; k++) {
                            nr = r + dr[k];
                            nc = c + dc[k];
                            if (map[nr][nc] == 1) {
                                queue.add(new Land(nr, nc));
                                map[nr][nc] = 0;
                            }
                        }
                    }

                }
            }
        }
        sb.append(count).append("\n");
    }


}
