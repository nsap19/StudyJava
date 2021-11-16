package hyemin;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2225_합분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        final int MOD = 1000000000;

        int[][] dp = new int[K + 1][N + 1]; //n까지의 수중에 k개를 더했을때 가능한 경우의 수
//        dp[k][n] = dp[k-1][0] + ... + dp[k-1][dp[n]

        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] += dp[i - 1][l];
                    dp[i][j] %= MOD;
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(dp[K][N]);

    }
}
