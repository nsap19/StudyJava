package hyemin;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때,
 * 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.

 * 다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다.
 * 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
 */
public class Programmers42861_섬연결하기 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}})); //4
    }

    private static int solution(int n, int[][] costs) {
        //임의의 한 섬에서 다른 섬으로 가는 경로가 다 존재하고, 그 경로가 최소가 되도록 찾아주면 된다고 생각
        //임의의 점은 0으로 설정
        //다익스트라?로 풀면 될것이라고 생각!

        int[][] matrix = new int[n][n];
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < costs.length; i++) {
            int v1 = costs[i][0];
            int v2 = costs[i][1];
            int cost = costs[i][2];

            matrix[v1][v2] = cost;
            matrix[v2][v1] = cost;
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0; //임의의 시작점을 0번으로 잡았기 때문에 0번까지의 거리는 0

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;
            sum += min;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && matrix[minIndex][j] != 0 && distance[j] > matrix[minIndex][j]) {
                    distance[j] = matrix[minIndex][j];
                }
            }
        }

        return sum;
    }
}
