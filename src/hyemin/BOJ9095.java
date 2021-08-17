package hyemin;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9095 {
    static int[] numbers = new int[]{1, 2, 3};
    static int total, N;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            int num = Integer.parseInt(br.readLine());
            total = 0;

            for (int i = 1; i <= num; i++) {
                N = i;
                result = new int[i]; //1개부터 number개(모두 1로 더한 것)의 자리까지 중복순열 생성
                permutationa(0, num);
            }
            sb.append(total + "\n");
        }
        System.out.println(sb);
    }

    private static void permutationa(int cnt, int res) { //중복순열
        if (cnt == N && res == 0) {
            total++;
//            System.out.println(Arrays.toString(result));
            return;
        } else if (cnt == N && res != 0) return; //모든 순열을 돌았지만 number가 만들어지지 않는 경우


        for (int i = 0; i < numbers.length; i++) {
            result[cnt] = numbers[i];
            permutationa(cnt + 1, res - numbers[i]);
        }


    }
}
