package hyemin;

import java.io.*;
import java.util.StringTokenizer;

/* N을 찾을 수 있는 k까지 구한 후, 직접 moo 수열을 구했더니 메모리 초과가 났다,,
그래서 인터넷에서 약간의 설명을 참고해서 풀었당
* */
public class BOJ5904_Moo게임 {
    static int N;
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        //S(k)의 k 찾기, 그리고 S(k)의 길이 찾기
        int k = 0;
        int len = 3;
        while (len <= N) {
            k++;
            len = len * 2 + k + 3;
        }

        findMoo(len, k);

        System.out.println(result);

    }

    private static void findMoo(int len, int k) {

        int mooLen = k + 3; //새로 생성되는 중간부분 길이
        int first = (len - mooLen) / 2; //S(k-1)의 길이
        int middle = first + mooLen; //S(k-1) + 새로 생성되는 중간부분 길이까지

        if (N <= first) { //앞 부분
            findMoo(first, k - 1);
        } else if (N <= middle) { //중간 부분
            N -= first;
            if (N == 1) result = "m";
            else result = "o";
        } else { //뒷부분
            N -= middle;
            findMoo(first, k - 1);
        }
    }
}
