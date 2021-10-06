package hyemin;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1 - BFS로 시도 -> 시간초과 ㅜ
// 2 - 숫자 오름차순으로 조회하면서 dp[r][c] = dp[nr][nc]값중 가장 큰값 +1 -> 틀렸습니다. -> 아마 각 칸의 숫자가 다르다는 조건이없어서 그런듯 ㅜ
// 3 - 알고리즘 분류 보니 dfs가 있어서 시도 -> 시간...초과......
// 4 - dfs의 재귀를 통해 메모이제이션... 중간에 실수가 있어서 오래걸렷지만 핵열,,,,
// map[r][c] > map[nr][nc]이면 nr,nc에 대한 dp값을 재귀를 통해 하향식으로 접근해서 메모이제이션함

public class BOJ1937_욕심쟁이판다 {
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dp;
    static int N, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j);
            }
        }


        System.out.println(max);
    }

    private static int dfs(int r, int c) {
        if (dp[r][c] != 1) return dp[r][c];

        for (int di = 0; di < 4; di++) {
            int nr = r + dr[di];
            int nc = c + dc[di];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (map[r][c] > map[nr][nc]) {
                dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
            }
        }

        max = Math.max(max, dp[r][c]);
        return dp[r][c];
    }
}
