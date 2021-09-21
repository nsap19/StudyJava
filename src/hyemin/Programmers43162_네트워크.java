package hyemin;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers43162_네트워크 {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(solution(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}}));


    }

    private static int solution(int n, int[][] computers){
        int answer = 0;

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n ; i++) {
            if(visited[i]) continue;

            answer++;
            queue.add(i);
            while (queue.size() > 0) {
                int num = queue.poll();
                if (visited[num]) continue;
                visited[num] = true;

                for (int j = 0; j < n; j++) {
                    if (j == num) continue;
                    if (computers[num][j] == 1) {
                        queue.add(j);
                    }
                }
            }
        }

        return answer;
    }


}
