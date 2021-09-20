package hyemin;

import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
    int city;
    int val;

    public Bus(int city, int val) {
        this.city = city;
        this.val = val;
    }

    @Override
    public int compareTo(Bus o) {
        return this.val - o.val;
    }
}

public class BOJ1916_최소비용구하기 {
    static ArrayList<Bus>[] list;
    static int[] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

//        입력
//        첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다.
//        그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다.
//        먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
//        그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다.
//        버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.
//
//        그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 도시의 번호는 1부터 N까지이다.
//        출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
//        A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라.

        int N = Integer.parseInt(br.readLine()); //도시의 갯수
        int M = Integer.parseInt(br.readLine()); //버스의 갯수
        list = new ArrayList[N + 1];
        dp = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list[a].add(new Bus(b, val));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start, end);
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;

        while (!pq.isEmpty()) {
            Bus cur = pq.poll();
            int curCity = cur.city;

            if (visited[curCity]) continue;
            visited[curCity] = true;
            for (Bus next : list[curCity]) {

                if (dp[next.city] > dp[curCity] + next.val) {
                    dp[next.city] = dp[curCity] + next.val;
                    pq.add(new Bus(next.city, dp[next.city]));
                }
            }
        }

        System.out.println(dp[end]);

    }
}
