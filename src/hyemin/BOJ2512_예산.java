package hyemin;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2512_예산 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int total = Integer.parseInt(br.readLine());
        int max = -1;
        int start = 0; //이부분을 arr[0]으로 해서 틀렸습니다가 무지하게 나왓당,,, 반례를 찾아보니 total이 터무늬없게 작은경우에 적정값을 찾지 못햇음,,,그래서 0으로 변경
        int end = arr[N - 1];
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (getSum(mid) > total) {
                end = mid - 1;
            } else {
                max = Math.max(max, mid);
                start = mid + 1;
            }
        }

        System.out.println(max);

    }

    private static int getSum(int num) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) sum += arr[i];
            else sum += num;
        }
        return sum;
    }
}
