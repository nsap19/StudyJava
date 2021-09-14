package hyemin;

import java.io.*;
import java.util.*;

class Sister {
    int loc;
    int time;

    public Sister(int loc, int time) {
        this.loc = loc;
        this.time = time;
    }

}

/*
* 3428ms가 나왓다,,,,
* 너무 오래걸려서 이게 맞는건지는 모르겠는데
* 암튼 맞긴 맞음,,,,, 꽤 찝찝함,,,,
*/
public class BOJ13549_숨바꼭질3 {
    static boolean[] visited;
    static int[] dist;
    static int dLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        visited = new boolean[100000000];
        dist = new int[100000000];
        dLen = dist.length;
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(start, end);
    }

    private static void dijkstra(int start, int end) {
//        PriorityQueue<Sister> pq = new PriorityQueue<>();
        Queue<Sister> pq = new LinkedList<>();
        pq.add(new Sister(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Sister cur = pq.poll();
            int curLoc = cur.loc;
            int curTime = cur.time;
            if(curLoc>=dLen) continue;

            if (visited[curLoc]) continue;
            visited[curLoc] = true;

            int n1 = curLoc * 2;
            int n2 = curLoc - 1;
            int n3 = curLoc + 1;

            if (n1 < dLen && dist[n1] > curTime) {
                dist[n1] = curTime;
                pq.add(new Sister(n1, curTime));
            }
            if (n2>=0 && n2 < dLen && dist[n2] > curTime + 1) {
                dist[n2] = curTime + 1;
                pq.add(new Sister(n2, curTime + 1));
            }
            if (n3 < dLen && dist[n3] > curTime + 1) {
                dist[n3] = curTime + 1;
                pq.add(new Sister(n3, curTime + 1));
            }

            if (n1 == end || n2 == end || n3 == end) break;
        }
        System.out.println(dist[end]);

    }
}
