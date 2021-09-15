package hyemin;

import java.io.*;

public class BOJ2661_좋은수열 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        backtracking("1", 1);

    }

    private static void backtracking(String str, int depth) {
        if (depth == N) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (check(str + i)) backtracking(str + i, depth + 1);
        }


    }

    private static boolean check(String str) { //좋은 수열인지 체크
        int len = str.length() / 2;

        for (int i = 1; i <= len; i++) {
            String str1 = str.substring(str.length() - i * 2, str.length() - i);
            String str2 = str.substring(str.length() - i);
//            System.out.println(str1+" "+str2);
            if (str1.equals(str2)) {
                return false;
            }
        }
        return true;

    }
}
