package hyemin;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int num;
    int len;

    Node(int num, int len) {
        this.num = num;
        this.len = len;
    }

    @Override
    public int compareTo(Node o) {
        return this.num - o.num;
    }
}

public class BOJ1167 {
    static LinkedList<Node>[] tree;
    static Stack<Integer> stack;
    static int sum, max, maxNode;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());

        tree = new LinkedList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new LinkedList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            while (true) {
                int v2 = Integer.parseInt(st.nextToken());
                if (v2 == -1) break;
                int len = Integer.parseInt(st.nextToken());

                tree[v1].add(new Node(v2, len));
            }
            Collections.sort(tree[v1]);
        }


        //원래 이 방식으로 구했을 때 예제도 다 맞았는데 시간초과가 났다 ㅜㅜ
//        for (int i = 1; i <= V; i++) {
//            sum = 0;
//            visited = new boolean[V + 1];
//            dfs(i, 0);
//        }

        //풀이를 참고했는데 사실 왜 이게 답인지 정확히는 모르겠다.
        //아무 정점에서 가장 먼 정점을 찾고, 그 정점에서 가장 먼 정점을 찾으라는데 이게 뭐,,,? 이건뭐,,,? ㅠㅠ
        //아무래도 트리의 루트가 1이 아니기때문에 이렇게 풀어야하는게 맞는듯 함

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(maxNode, 0);

        System.out.println(max);

    }

    private static void dfs(int v, int sum) {
        if (max < sum) {
            max = sum;
            maxNode = v;
        }

        visited[v] = true;

        for (Node node : tree[v]) {
            if (!visited[node.num]) {
                dfs(node.num, sum + node.len);
                //항상 재귀의 파라미터는 직접 값을 더하지말고 더한값을 전달하자 ㅜ
            }
        }

    }
}

