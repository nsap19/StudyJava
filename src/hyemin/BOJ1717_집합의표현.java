package hyemin;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1717_집합의표현 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (str.equals("0")) { //합집합
                union(a, b);
            } else {
                if (find(a) == find(b)) sb.append("YES");
                else sb.append("NO");

                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        if (ap == bp) return;
        parents[ap] = bp;
    }

    private static int find(int a) {
        if (parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }
}
