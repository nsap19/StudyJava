package hyemin;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //배열 갯수
        int M = Integer.parseInt(st.nextToken()); //목표 수

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt, end;
        cnt = end = 0;
        int sum = 0;
        for (int start = 0; start < N; start++) {
            while (sum < M && end < N) {
                sum += arr[end++];
            }
            if (sum == M) cnt++;
            sum -= arr[start];
        }
        System.out.println(cnt);
    }
}
