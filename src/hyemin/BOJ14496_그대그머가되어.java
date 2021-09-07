package hyemin;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14496_그대그머가되어 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken()); //치환하고자하는 문자 a
        int b = Integer.parseInt(st.nextToken()); //치환하고자하는 문자 b
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //문자의 갯수
        int M = Integer.parseInt(st.nextToken()); //치환가능한 문자쌍의 갯수

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        bfs(a, b);
        if (a!=b && depth[b] == 0) System.out.println(-1); //a==b인 경우 0을 처리해줘야하기 때문에 조건 추가
        else System.out.println(depth[b]);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        depth[start] = 0;

        loop:
        while (!queue.isEmpty()) {
            int cur = queue.poll();
//            System.out.println(cur);
            for (int next : list[cur]) {
//                System.out.println(next);
                if (visited[next]) continue;

                visited[next] = true;
                depth[next] = depth[cur] + 1;
                queue.add(next);
                if (next == end) break loop;
            }
        }

    }
}
