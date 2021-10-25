package hyemin;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7453_합이0인네정수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[N * N];
        int[] cd = new int[N * N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ab[index] = arr[0][i] + arr[1][j];
                cd[index] = arr[2][i] + arr[3][j];
                index++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);
//        System.out.println(Arrays.toString(ab));
//        System.out.println(Arrays.toString(cd));

        long answer = 0;
        for (int abid = 0, cdid = index - 1; abid < index && cdid >= 0; ) {
            int abNum = ab[abid];
            int cdNum = cd[cdid];
            int abCnt = 0; //ab배열 중복수 체크
            int cdCnt = 0; //cd배열 중복수 체크
            int sum = abNum + cdNum;
            if (sum == 0) {
                while (abid < index && abNum == ab[abid]) {
                    abid++;
                    abCnt++;
                }
                while (cdid >= 0 && cdNum == cd[cdid]) {
                    cdid--;
                    cdCnt++;
                }
                answer += (long)abCnt * (long)cdCnt;
            } else if (sum < 0) abid++;
            else cdid--;
        }
        System.out.println(answer);


    }
}
