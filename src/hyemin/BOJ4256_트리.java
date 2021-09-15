package hyemin;

/**
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스의 첫째 줄에는 노드의 개수 n이 주어진다. (1 ≤ n ≤ 1,000)
 * BT의 모든 노드에는 1부터 n까지 서로 다른 번호가 매겨져 있다. 다음 줄에는 BT를 전위 순회한 결과, 그 다음 줄에는 중위 순회한 결과가 주어진다.
 * 항상 두 순회 결과로 유일한 이진 트리가 만들어지는 경우만 입력으로 주어진다.
 * <p>
 * 출력
 * 각 테스트 케이스마다 후위 순회한 결과를 출력 한다.
 */

import java.io.*;

public class BOJ4256_트리 {
    static String[] pre, in;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            pre = br.readLine().split(" ");
            in = br.readLine().split(" ");

            getPost(0, n, 0);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void getPost(int start, int end, int root) {

        for (int i = start; i < end; i++) {
            if (in[i].equals(pre[root])) {
                getPost(start, i, root + 1); //left
                getPost(i + 1, end, root + i - start + 1); //right. root의 인자값은 root+(left의 길이값)
                sb.append(pre[root]).append(" ");
            }
        }
    }
}

