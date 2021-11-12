package hyemin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1967_트리의지름 {
    static List<Node>[] list;
    static boolean[] visited;
    static int maxNode, max = 0;

    static class Node {
        int num, weight;

        public Node(int end, int weight) {
            this.num = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(maxNode, 0);

        System.out.println(max);
    }

    private static void dfs(int v, int sum) {
        if (sum > max) {
            max = sum;
            maxNode = v;
        }

        visited[v] = true;

        for (Node node : list[v]) {
            if (!visited[node.num]) {
                dfs(node.num, sum + node.weight);
            }
        }
    }
}
