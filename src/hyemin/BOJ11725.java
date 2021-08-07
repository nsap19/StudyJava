package hyemin;

import java.io.*;
import java.util.*;

public class BOJ11725 {
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //노드의 갯수
        LinkedList<Integer>[] tree = new LinkedList[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new LinkedList<>();
        }

        int a, b;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
        bfs(1, tree);
        for (int j = 2; j <= N; j++) {
            System.out.println(result[j]);
        }
    }

    private static void bfs(int start, LinkedList<Integer>[] tree) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        result[start] = 1;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int child : tree[parent]) {
                if (result[child] == 0) {
                    result[child] = parent;
                    queue.offer(child);
                }
            }
        }
    }
}
