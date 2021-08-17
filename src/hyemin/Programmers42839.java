package hyemin;


import java.util.ArrayList;

public class Programmers42839 {
    static int[] number, result;
    static boolean[] visited;
    static int N;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));

    }

    private static int solution(String numbers) {
        number = new int[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            number[i] = numbers.charAt(i) - '0';
        }

        list = new ArrayList<>();
        for (int i = 1; i <= numbers.length(); i++) { //1부터 numbers.length() 자리수만큼 순열 만들기
            result = new int[i];
            visited = new boolean[numbers.length()];
            N = i;

            permutation(0);
        }

//        System.out.println(list.toString());

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            cnt++;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) { //1과 자신 외의 다른수로 나누어떨어진다면 소수가 아님
                    cnt--;
                    break;
                }
            }
        }

        return cnt;

    }

    private static void permutation(int cnt) { //순열 만들기
        if (cnt == N) {
            int num = 0;
            int tmp = 1;
            for (int i = 0; i < N; i++) {
                num += result[i] * tmp;
                tmp *= 10;
            }
            if (!list.contains(num) && num > 1) //소수는 1보다 큰 자연수이므로
                list.add(num);
            return;
        }

        for (int i = 0; i < number.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            result[cnt] = number[i];
            permutation(cnt + 1);
            visited[i] = false;
        }
    }

}
