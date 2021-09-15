package hyemin;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1038_감소하는수 {
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //N번째 감소하는 수 찾기
        if (N <= 10) System.out.println(N);
        else if (N > 1022) System.out.println(-1);
        else {
            for (int i = 0; i < 10; i++) {
                backtracking((long) i, 1);
            }
            Collections.sort(list);
//            System.out.println(list.size()); //1021
//            System.out.println(list.toString());
            System.out.println(list.get(N));
        }


    }

    private static void backtracking(Long num, int depth) {
        if (depth > 10) return;

//        System.out.println(num);
        list.add(num);

        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) {
                backtracking((num * 10) + i, depth + 1);
            }
        }

    }


}
