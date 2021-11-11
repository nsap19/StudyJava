package hyemin;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ3584_가장가까운공통조상 {
    static List<Integer>[] list;
    static ArrayList<Integer> parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            list = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                list[n2].add(n1);
            }

            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            parents = new ArrayList<>();
            dfs(node1);
//            System.out.println(Arrays.toString(parents.toArray()));
            sb.append(find(node2)).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        parents.add(node);
        for (Integer p : list[node]) {
            dfs(p);
        }
    }

    private static int find(int node) {
        if (parents.contains(node)) return node;
        for (Integer p : list[node]) {
            return find(p);
        }
        return 0;
    }
}
