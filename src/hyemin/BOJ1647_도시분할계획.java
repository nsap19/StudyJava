package hyemin;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1647_도시분할계획 {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int N, M;
    static Edge[] edgeList;
    static int[] parents;

    private static void make() {
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        if (ap == bp) return false;
        parents[bp] = ap;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edgeList = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(s, e, w);
        }

        Arrays.sort(edgeList);

        make();
        int cnt = 0, result = 0;
        for (Edge edge : edgeList) {
            if (union(edge.start, edge.end)) {

                System.out.println(edge.start + " " + edge.end + " " + edge.weight);
                result += edge.weight;
                if (++cnt == N - 2) break;
            }
        }

        System.out.println(result);
    }
}
