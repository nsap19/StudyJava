package hyemin;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int x = 0, y = 0;
        while (start < end) {
            sum = arr[start] + arr[end];

            if (Math.abs(sum) < min) {
                x = arr[start];
                y = arr[end];
                min = Math.abs(sum);
            }

            if (sum > 0) end--;
            else start++;
        }

        System.out.println(x + " " + y);
    }
}
