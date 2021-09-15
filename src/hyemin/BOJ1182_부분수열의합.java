package hyemin;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1182_부분수열의합 {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            backtracking(arr[i], i);
        }

        System.out.println(count);
    }

    private static void backtracking(int num, int depth) {
        if (depth == N - 1 && num == S) {
            count++;
            return;
        }

        depth++;
        if (depth < N) {
            backtracking(num + arr[depth], depth);
            backtracking(num, depth);
        }
    }
}
