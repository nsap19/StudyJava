package hyemin;

import java.util.Arrays;

public class Programmers42860_조이스틱 {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN")); //56
        System.out.println(solution("JAN")); //23
        System.out.println(solution("AAA")); //0
        System.out.println(solution("ABAAAAAAAAABB")); //7
    }

    private static int solution(String name) {
        int[] num = new int[name.length()];

        int cnt = 0;
        for (int i = 0; i < name.length(); i++) {
            num[i] = name.charAt(i) - 'A';
            if (num[i] != 0) cnt++;
        }

        int sum = 0;
        // 위, 아래 조이스틱 처리
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0) continue;
            else if (num[i] < 13) sum += num[i];
            else sum += (26 - num[i]);
        }

        //왼쪽, 오른쪽 조이스틱 처리
        int i = 0;
        int dir = 1;
        while (cnt>1) {
            if (num[i] == 0) { //'A'인 경우 처리안하고 그냥 넘어감, 넘어가는 방향은 이전 처리 방향(dir)
                i += dir;
                sum++;
                continue;
            }

            num[i] = 0;
            //오른쪽으로 이동하는 경우
            int len1 = 1;
            int index1 = i + 1;
            while (true) {
                if (index1 == num.length) index1 = 0;
                if (num[index1] != 0) break;
                if (num[index1] == 0) {
                    len1++;
                    index1++;
                }
            }

            //왼쪽으로 이동하는 경우
            int len2 = 1;
            int index2 = i - 1;
            while (true) {
                if (index2 < 0) index2 = num.length - 1;
                if (num[index2] != 0) break;
                if (num[index2] == 0) {
                    len2++;
                    index2--;
                }
            }


            if (len1 <= len2) { //오른쪽으로 이동하는게 빠른 경우
                sum += len1;
                i = index1;
                dir = 1;
            } else { //왼쪽으로 이동하는게 빠른 경우
                sum += len2;
                i = index2;
                dir = -1;
            }
            cnt--;
        }
        return Math.max(sum , 0);
    }
}