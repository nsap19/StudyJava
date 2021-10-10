package hyemin;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1365_꼬인전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < N; i++) {
            int end = list.get(list.size() - 1);
            if (arr[i] == end) continue;
            else if (end < arr[i]) list.add(arr[i]);
            else {
                int left = 0;
                int right = list.size() - 1;
                int mid = 0;
                while (left < right) {
                    mid = (left + right) / 2;
                    if (arr[i] <= list.get(mid)) right = mid - 1;
                    else left = mid + 1;
                }
                list.set(right, arr[i]);
            }
        }
//        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(N - list.size());


    }


}
