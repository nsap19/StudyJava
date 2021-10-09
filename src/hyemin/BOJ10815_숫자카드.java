package hyemin;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815_숫자카드 {
    static int N, card[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        card = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int arr[] = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        for (int i = 0; i < M; i++) {
            sb.append(find(arr[i])).append(" ");
        }

        System.out.println(sb);
    }

    private static int find(int num) {
//        System.out.println("--"+num);
        int start = 0, end = N - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
//            System.out.println(start+" "+end+" "+mid);
            if (card[mid] == num) return 1;
            if (card[mid] < num) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }
}
