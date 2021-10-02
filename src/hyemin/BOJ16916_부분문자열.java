package hyemin;

import java.io.*;

/* 이건 이론 대충 알겠고, 코드도 대충할겠는데
안보고 짜라하면 아직 못짜겟다,,,
이론 코드 둘다 대충 아는것도 넘 찝찝하고,,, 좀 더 연습해봐야할듯!
* */

public class BOJ16916_부분문자열 {
    static char[] text, pattern;
    static int pi[], tLength, pLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        text = br.readLine().toCharArray();
        pattern = br.readLine().toCharArray();

        tLength = text.length;
        pLength = pattern.length;

        pi = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (pattern[i] == pattern[j]) pi[i] = ++j;
        }

        if (check()) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean check() {
        for (int i = 0, j = 0; i < tLength; i++) {
            while (j > 0 && text[i] != pattern[j]) j = pi[j - 1];

            if (text[i] == pattern[j]) {
                if (j == pLength - 1) {
                    return true;
                } else j++;
            }
        }
        return false;
    }
}
