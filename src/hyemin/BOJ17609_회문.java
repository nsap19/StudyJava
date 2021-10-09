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
        int result;
        for (int i = 0; i < N; i++) {
            String[] str = arr[i];
            int left = 0, right = str.length - 1;

            result = 2;
            int[] rt = rotate(str, left, right);
            left = rt[0];
            right = rt[1];

            if (left >= right) {
                result = 0;
            } else { // 애먹었던 문제 반례 cccfccfcc - 밑에 두 조건문을 분리해줘서 핵열~
                int tl = 0, tr = 0;
                if (str[left].equals(str[right - 1])) {
                    rt = rotate(str, left, right - 1);
                    tl = rt[0];
                    tr = rt[1];
                    if (tl >= tr) {
                        result = 1;
                    }
                }
                if (str[right].equals(str[left + 1])) {
                    rt = rotate(str, left + 1, right);
                    tl = rt[0];
                    tr = rt[1];
                    if (tl >= tr) {
                        result = 1;
                    }
                }
            }

//            System.out.println(left + " " + right);

            System.out.println(result);
        }

    }

    private static int[] rotate(String[] str, int left, int right) {
        while (left < right && str[left].equals(str[right])) {
            left++;
            right--;
        }
        return new int[]{left, right};
    }
}
