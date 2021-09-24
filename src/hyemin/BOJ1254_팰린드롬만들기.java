package hyemin;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1254_팰린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        String originStr = br.readLine();
        int result = 0;
        for (int i = 0; i <= originStr.length(); i++) {
            String temp = originStr;
            for (int j = i; j > 0; j--) {
                temp += originStr.charAt(j - 1);
            }
//            System.out.println(temp);
            if (check(temp)) {
                result = temp.length();
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean check(String str) {
        boolean flag = true;
        int len = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
