package hyemin;

import java.io.*;
import java.util.*;


public class BOJ1240_노드사이의거리 {
    static ArrayList<Node>[] list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list[num1].add(new Node(num2, len));
            list[num2].add(new Node(num1, len));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            sb.append(getLength(num1, num2)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getLength(int num1, int num2) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(new Node(num1, 0));
        visited[num1] = true;

        int lenSum = 0;
        while (queue.size() > 0) {
            Node node = queue.poll();
            int num = node.num;

            if (num == num2) {
                lenSum = node.len;
                break;
            }

            for (Node next : list[num]) {
                if (visited[next.num]) continue;
                visited[next.num] = true;
                queue.add(new Node(next.num, node.len+next.len));
            }
        }

        return lenSum;
    }
}
