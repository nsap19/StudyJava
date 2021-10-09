package hyemin;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
처음에는 그냥 dfs로 접근하면 될것이라고 생각
근데 그렇게 했더니 안풀리는 문제가 있거나 메모리초과가 났음 (시작점을 항상 1이라고 생각했는데 반례가 있어 틀렷던거엿음!)
그래서 시작점을 찾을 수 있으려면 어떻게 해야하나 했더니 위상정렬을 써야한다고 나와있어서
위상정렬 사용 (위상정렬은 찾아보니 방향이 있고, 사이클이 없는 경우 사용가능하다고함)
직전의 건물들이 모두 지어지고 난 후 다음 건물이 지어질 수 있기 때문에 (indegree가 0인 상태가 되어야 큐에 추가)
위상정렬이 꼭 필요한 문제였던것 같다
*/
public class BOJ1005_ACMCraft {
    static int N, target;
    static int[] times, indegree;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); //건물의 갯수
            int M = Integer.parseInt(st.nextToken()); //건물의 규칙 갯수

            times = new int[N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) times[i] = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

            indegree = new int[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                indegree[b]++;
            }

            target = Integer.parseInt(br.readLine());

            sb.append(getTimes()).append("\n");
        }
        System.out.println(sb);

    }

    private static int getTimes() {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            result[i] = times[i];

            if (indegree[i] == 0) queue.offer(i);
        }

        while (queue.size() > 0) {
            int cur = queue.poll();

            for (int i : list[cur]) {
                result[i] = Math.max(result[i], result[cur] + times[i]);
                indegree[i]--;
                if (indegree[i] == 0) queue.offer(i);
            }
        }

        return result[target];
    }
}

