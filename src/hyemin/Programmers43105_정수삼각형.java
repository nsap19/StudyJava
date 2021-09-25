package hyemin;

import java.io.*;
import java.util.StringTokenizer;

public class Programmers43105 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    private static int solution(int[][] triangle) {
        int answer = 0;

        int h = triangle.length;
        int[][] dp = new int[h][h];
        

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < h; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j==0) dp[i][j] = dp[i-1][j];
                else if(j==dp[i].length) dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
                }
                dp[i][j]+= triangle[i][j];
            }
        }

        for (int i = 0; i < h; i++) {
            answer = Math.max(answer, dp[h-1][i]);
        }

        return answer;
    }
}
