package hyemin;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17609_회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }

        // 회문 0
        // 유사회문 1
        // 그 외 2
        for (int i = 0; i < N; i++) {
            String[] str = arr[i];
            int left = 0, right = str.length - 1;
            boolean flag = true;
            while (left < right && str[left].equals(str[right])) {
                left++;
                right--;
            }
            if(left>right) flag= true;
            else if(str[left].equals(str[right])){}

        }
    }
}
